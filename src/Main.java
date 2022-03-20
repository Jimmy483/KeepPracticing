import java.util.*;

public class Main {
 String[][] pointer=new String[3][3];
 String X="X";
 boolean cont=false;
 boolean gameFinished=false;
 List<Integer> cpuPossibleMoves=new ArrayList<>();
 boolean userWin=false;
 boolean cpuWin=false;
// List<Integer> cpuMoves=new ArrayList<>();
// List<Integer> userMoves=new ArrayList<>();
 public Main(){
     program();
    }
    public static void main(String[] args) {
       new Main();
    }

    public void program(){
     clearBoard();


        showBoard();

        System.out.println("Note:The room at the top left is number 1 and bottom right is number 9");
        //int count=0;
        do {
            while(!gameFinished&&!cpuWin&&!userWin){
                System.out.println("Please select a room number to tick(1-9)");
                Scanner sc=new Scanner(System.in);
                while (!sc.hasNextInt()){
                    System.out.println("Pease enter a valid room number");
                    sc.next();
                }
                int choice=sc.nextInt();
                if(choice>9||choice<1){
                    System.out.println("Invalid Number");
                    System.out.println("Ending program");
                    try {
                        Thread.sleep(1000);
                        System.out.println("3");
                        Thread.sleep(1000);
                        System.out.println("2");
                        Thread.sleep(1000);
                        System.out.println("1");
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                tick(choice,"X");
                //userMoves.add(choice);
                gameFinished=cpuMove();
                System.out.println(cpuPossibleMoves);
                userWin=checkWin("X");
                if(userWin){
                    System.out.println("You Win");
                    //showBoard();
                }
                if(cpuPossibleMoves.size()>0 && !userWin){
                    Random rn=new Random();
                    int cpuTick=rn.nextInt(cpuPossibleMoves.size());
                    tick(cpuPossibleMoves.get(cpuTick),"O");
                    cpuWin=checkWin("O");
                    //cpuMoves.add(cpuPossibleMoves.get(cpuTick));
                }
                if(cpuWin){
                    System.out.println("You Lose");
                    //showBoard();
                }

                showBoard();
                //count++;

            }
            if(gameFinished){
                System.out.println("Game was a tie");
            }
            System.out.println("New Game?(Y/N)");
            Scanner sc=new Scanner(System.in);
            String userChoice=sc.next();
            if(userChoice.toLowerCase().equals("y")){
                cont=true;
            }
            cpuPossibleMoves.clear();
            cpuWin=false;
            userWin=false;
            gameFinished=false;
            clearBoard();
        }while (cont);
    }

    public void tick(int choice,String mark){
        switch (choice){
            case 1:
                pointer[0][0]=mark;
                break;
            case 2:
                pointer[0][1]=mark;
                break;
            case 3:
                pointer[0][2]=mark;
                break;
            case 4:
                pointer[1][0]=mark;
                break;
            case 5:
                pointer[1][1]=mark;
                break;
            case 6:
                pointer[1][2]=mark;
                break;
            case 7:
                pointer[2][0]=mark;
                break;
            case 8:
                pointer[2][1]=mark;
                break;
            case 9:
                pointer[2][2]=mark;
                break;
        }
    }

    public void showBoard(){
        System.out.println(" "+pointer[0][0]+"|" + " "+pointer[0][1]+"|" +" "+pointer[0][2]);
        System.out.println("-- " +"--" +" --");
        System.out.println(" "+pointer[1][0]+"|"+" "+pointer[1][1]+"|" + " "+pointer[1][2]);
        System.out.println("-- "+"--" + " --");
        System.out.println(" "+pointer[2][0] +"|" + " "+pointer[2][1]+"|"+" " + pointer[2][2]);
    }

    public void clearBoard(){
        for(int i=0;i< pointer.length;i++){
            for(int j=0;j< pointer.length;j++){
                pointer[i][j]=" ";
            }
        }
    }


    public boolean checkWin(String mark){
     //win lines
        //1,2,3  4,5,6   7,8,9   1,4,7   2,5,8   3,6,9   1,5,9  3,5,7
//        for(int i=0;i< pointer.length;i++){
//            for(int j=0;i< pointer.length;j++){
//                if(pointer[i][j].equals(mark)){
//
//                }
//            }
//
//        }
        boolean win=false;
        if(!mark.equals("")){
            if(pointer[0][0].equals(mark) && pointer[0][1].equals(mark) && pointer[0][2]==mark){
                win=true;
            }else if(pointer[1][0].equals(mark) && pointer[1][1].equals(mark) && pointer[1][2]==mark){
                win=true;
            }else if(pointer[2][0].equals(mark) && pointer[2][1].equals(mark) && pointer[2][2]==mark){
                win=true;
            }else if(pointer[0][0].equals(mark) && pointer[1][0].equals(mark) && pointer[2][0]==mark){
                win=true;
            }else if(pointer[0][1].equals(mark) && pointer[1][1].equals(mark) && pointer[2][1]==mark){
                win=true;
            }else if(pointer[0][2].equals(mark) && pointer[1][2].equals(mark) && pointer[2][2]==mark){
                win=true;
            }else if(pointer[0][0].equals(mark) && pointer[1][1].equals(mark) && pointer[2][2]==mark){
                win=true;
            }else if(pointer[0][2].equals(mark) && pointer[1][1].equals(mark) && pointer[2][0]==mark){
                win=true;
            }
        }

        return win;


    }

    public boolean cpuMove(){
     boolean check=false;
     cpuPossibleMoves.clear();
     for(int i=0;i< pointer.length;i++) {
         for (int j = 0; j < pointer.length; j++) {
             if (pointer[i][j] == " ") {
                 check = true;
                 if (i == 0 && j == 0) {
                     cpuPossibleMoves.add(1);
                 } else if (i == 0 && j == 1) {
                     cpuPossibleMoves.add(2);
                 } else if (i == 0 && j == 2) {
                     cpuPossibleMoves.add(3);
                 } else if (i == 1 && j == 0) {
                     cpuPossibleMoves.add(4);
                 } else if (i == 1 && j == 1) {
                     cpuPossibleMoves.add(5);
                 } else if (i == 1 && j == 2) {
                     cpuPossibleMoves.add(6);
                 } else if (i == 2 && j == 0) {
                     cpuPossibleMoves.add(7);
                 } else if (i == 2 && j == 1) {
                     cpuPossibleMoves.add(8);
                 } else if (i == 2 && j == 2) {
                     cpuPossibleMoves.add(9);
                 }
             }
         }
     }
     if(check==false){
         return true;
     }
     return false;
    }
}
