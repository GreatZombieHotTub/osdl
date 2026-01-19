class NewThread2 extends Thread{
    NewThread2(){
        super("demo thread");
        System.out.println("child thread: "+ this);
    }
    @Override
    public void run(){
        try {
            for(int i=5; i>0; i--){
                System.out.println("Child thread: "+ i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Existing child thread");
    }
}



public class ExtendedThread {
    public static void main(String[] args) {
        NewThread2 nt=new NewThread2();
        nt.setName("My demo thread is using RUNNABLE");
        nt.start();
        try {
            for(int n=5; n>0; n--){
                System.out.println("main thread: "+ n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
        System.out.println("exiting main thread");
    }
}

