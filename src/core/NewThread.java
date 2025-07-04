package core;

public class NewThread extends Thread{

    private  String text;
    private  String name;
    private  long sleep;

    public NewThread(String text){
        this.text = text;
    }
    public NewThread(String text, String name){
        this.text = text;
        this.name = name;
    }
    public NewThread(String text, long sleep){
        this.text = text;
        this.sleep = sleep;
    }


    public void run(){
        if (sleep > 0){
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (name != null)
            System.out.print( name + text);
        else
            System.out.print(text);
    }
}
