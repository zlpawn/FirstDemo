package Test;

public class ABC_Flag {
    private volatile static boolean flag1 = false;
    private volatile static boolean flag2 = false;
    private volatile static boolean flag3 = true;

    static class ThreadA extends Thread{
        public void run(){
            int i = 0;
            while(i < 10){
                if(flag3){
                    System.out.print("A");
                    flag1 = true;
                    flag3 = false;
                    i++;
                }
            }
        }
    }

    static class ThreadB extends Thread{
        public void run(){
            int i = 0;
            while(i < 10){
                if(flag1){
                    System.out.print("B");
                    flag2 = true;
                    flag1 = false;
                    i++;
                }
            }
        }
    }

    static class ThreadC extends Thread{
        public void run(){
            int i = 0;
            while(i < 10){
                if(flag2){
                    System.out.println("C");
                    flag3 = true;
                    flag2 = false;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();

        c.start();
        a.start();
        b.start();
    }

}
