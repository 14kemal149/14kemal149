/**
 * Ahmet Kemal BAYRAKTAR
 * 20120205013
 * 29.11.2021
 * Crazymarket için java kodu
 * 
 */
public class QServer {

    Customer[] queue = new Customer[1000];

    
    
    int front = 0, back = 0; // head&tail of queue
    

    
    /**
     * enqueue a customer to queue
     */
    boolean enqueue(Customer customer) {
        if( front ==0&&back == 999){
        System.out.println("sira suan dolu!!");
            return true;
        }
        else{
            System.out.println("ekleniyor");
            
            queue[back] = customer;
            back++;
            return true;
        }
        

    }


    void doldurma(){
        for(int k = 0 ; k<1000 ; k++){
            enqueue(new Customer());
            
         }
     

    } 
    /**
     * dequeue a customer from queue
     * 
     */
    Customer dequeue() {
        if(front==0&&back == 0){
        System.out.println("sira suan bos!!");
        return null;
        }
        else{
            Customer a = queue[front];
            queue[front] = null;
            front++;
            return a;
        }
    }

    /**
     * peek a customer in queue
     * 
     */
    Customer peek() {
        return queue[front];
    }

    /** kuruktaki toplam eleman sayisi */
    int size() {
        return back+1;
    }

    boolean isEmpty() {
        return front==999;
    }
}