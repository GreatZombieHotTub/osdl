
class Book {
        private int ID;
        private String title;
        private String author;
        private double price;
        private String status;

        public void setid(int a){
            this.ID=a;
        }
        public void settitle(String s){
            this.title=s;
        }
        public void setauthor(String s){
            this.author=s;
        }
        public void setstatus(String x){
            this.status=x;
        }
        public void setprice(double p){
            if(p>0){
            this.price=p;}
            else{ 
                System.out.println("invalid input");  }
    }

    public int getID(){
        return ID;
    }
    public String gettitle(){
        return title;
    }
    public String getauthor(){
        return author;
    }
    public double getprice(){
        return price;
    }
    public String status(){
        return status;
    }
    
}


public class EX1{
    public static void main(String[] args) {
        Book b1=new Book();
        b1.setid(1);
        b1.settitle("kahani");
        b1.setauthor("writer");
        b1.setprice(1000);
        b1.setstatus("issued");

        System.out.println("book details");
        System.out.println("ID:" + b1.getID());
        System.out.println("title:"+ b1.gettitle());
        System.out.println("baaki samajh jaao");

}}