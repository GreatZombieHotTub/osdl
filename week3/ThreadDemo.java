class NewThread implements Runnable{
    Thread t;
    NewThread(){
        t= new Thread(this, "Demo Thread");
        System.out.println("Child thread: "+ t);
        t.start();}
    
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


public class ThreadDemo {
    public static void main(String[] args) {
        NewThread nt=new NewThread();
        nt.t.setName("My demo thread is using RUNNABLE");
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
