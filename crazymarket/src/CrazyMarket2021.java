
import java.util.Random;

/**
 * Ahmet Kemal BAYRAKTAR
 * 20120205013
 * 29.11.2021
 * Crazymarket icin java kodu
 * 
 */
public class CrazyMarket2021 {
    /** parameters for simulations */
    double lambda;
    /** arrival rate */
    double mu;
    /** service rate */

    /**
     * number of customers to be served. (simulation is done after Nth customer
     * served)
     */
    double N;

    public CrazyMarket2021(double lambda, double mu, int n) {//constructer
        this.lambda = lambda;
        this.mu = mu;
        this.N = n;
    }

    QServer qServer = new QServer();


    

    QLottery qLottery = new QLottery();


    /* variables for statistics */
    double meanWaitingTime = 0; // mean waiting time of SERVED customers ortalama   
    double totalWaitingTime = 0; // total waiting time of SERVED customers
    double meanServiceTime = 0; // mean service time of SERVED customers
    double totalServiceTime = 0; // total service time of SERVED customers

    double Wthreshold = 0.1;//qserver dan qlottery e atama yapmak için tanımlanan eşik değeri

    double time = 0;// simulator çalışırken zaman akacağından dolayı akan zamanı simüle eden değişken
    boolean kasa = false;//if else leri kontrol etmek için tanımlanan değişken

    
    
    Customer customerX = qServer.peek();//customerX o anki işlem yapılan müşteri
    Random random = new Random();
    double u;


    public void simulateMarket() {
        qServer.doldurma();//simülasyon başlarken qserver adlı sıraya 1000 adet yeni müşteri enqueue ediliyor
        
        customerX = qServer.peek();


        
        while (!qServer.isEmpty()) {//bu dön
            
           
            



            if (!kasa) {// arrival event bekleme

                

                
                u = random.nextDouble();

                double interArrivalTime = -Math.log(u)/(lambda);

                customerX.waitingTime = time;

                totalWaitingTime += customerX.waitingTime;

               
                time += interArrivalTime;
                
                System.out.println(interArrivalTime+"aaaaaaaaaaaaaaaaaaaaa");

                if(interArrivalTime < Wthreshold)
                qLottery.add(qServer.dequeue());

        
                

               
                
                kasa = true;



                System.out.println("aadeparture event");
            } else { //kasa işlemi

                customerX = qServer.dequeue();
                //waiting time
                
                u = random.nextDouble();
                customerX.serviceTime = -Math.log(u)/(mu);

             


                time += customerX.serviceTime;
                totalServiceTime+= customerX.serviceTime;

               
                kasa = false;
                System.out.println(qServer.front+time);
                


                // departure event
                System.out.println("departure event");
            }
            
        }

        kasa = false;
        Random e = new Random();
        int er;

        while(!qLottery.isEmptyArray()){//lotteryden musteri alma
            if(!kasa){ //arrival

                u = random.nextDouble();

                double interArrivalTime = -Math.log(u)/(lambda);

                customerX.waitingTime = time;

                totalWaitingTime += customerX.waitingTime;

               
                time += interArrivalTime;

                kasa = true;
                System.out.println("aa");

            }
            else{//service
                er=e.nextInt(100);
                if(qLottery.lotteryArray[er] != null){
                    qLottery.remove(er);

                    u = random.nextDouble();
                    customerX.serviceTime = -Math.log(u)/(mu);

                  
    
    
                    time += customerX.serviceTime;
                    totalServiceTime+= customerX.serviceTime;


                    kasa = false;
                    System.out.println("bb");

                }

                System.out.println("cc");

            }
        }
        meanServiceTime = totalServiceTime/N;
        meanWaitingTime = totalWaitingTime/N;

    }

    public void printStatistics() {
        System.out.println("totalWaitingTime:" + totalWaitingTime);
        System.out.println("meanWaitingTime:" + meanWaitingTime);
        System.out.println("totalServiceTime:" + totalServiceTime);
        System.out.println("meanServiceTime:" + meanServiceTime);
        
       
    }

    public static void main(String[] args) {
        double lambda = Double.parseDouble(args[0]);
        double mu = Double.parseDouble(args[1]);
        int N = 1000;
        CrazyMarket2021 cm = new CrazyMarket2021(lambda, mu, N);
        cm.simulateMarket();
        cm.printStatistics();

    }

}