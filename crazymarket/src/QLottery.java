/**
 * Ahmet Kemal BAYRAKTAR
 * 20120205013
 * 29.11.2021
 * Crazymarket için java kodu
 * 
 *
 * TODO: indeksle cikarma islemenin ve ekleme isleminin verimli oldugu bir
 * implementasyon yapmaniz istenmektedir.
 */
public class QLottery {

    Customer[] lotteryArray = new Customer[100];

    boolean add(Customer a){//ekleme islemi dizide bos olan yerlere yapiliyor. Cıkarma islemi indexle yapildigindan siralamanin onemi yoktur. Bundan dolayi ekleme islemi bos olan yerlere yapiliyor.

        for(int k = 0 ; k < lotteryArray.length; k++){
            if(isEmptyIndex(k)){

                lotteryArray[k] = a;

                break;

            }


        }

        return false;
    }

    Customer remove(int r){//cikarma islemi index ile yapilmaktadir.

        Customer ret = lotteryArray[r];

        lotteryArray[r] = null;

        return ret;
    }
    
    boolean isEmptyArray(){//dizinin ici kontrol ediliyor.
        boolean ret = false;
        int a=0;
        for(int k = 0;k < 100;k++){
            if(lotteryArray[k]==null)
            a++;

            
            
        }
        if(a==100)
            ret = true;

        return ret ;
    }
    boolean isEmptyIndex(int i){//dizi elemanlari kontrol ediliyor.
        

        return lotteryArray[i]==null;
    }



}
