import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class Reception implements Runnable {
    private BufferedReader in;
    private String message = null, login = null;

    public Reception(BufferedReader in, String login){
        this.in = in;
        this.login = login;

    }

    

    public void run() {

        while(true){
            try {
            message = in.readLine();
            if(message.compareTo("F")==0){
            System.out.println(login+" a frappe "+ getAdversaire());
            } 
            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }


    String getAdversaire(){
        String adversaire="";
        try{
            Scanner sc = new Scanner(new File("auths.txt"));
            while(sc.hasNext()){
                String log= sc.nextLine();
                int a=0;
                for(int i=0;i<log.length();i++){
                    if(log.charAt(i)==' '){
                        a=i;
                        break;
                    }
                }
                log=log.substring(0, a);

                if(!log.equals(login)){
                    adversaire=log;
                    break;
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return adversaire;
    }


}