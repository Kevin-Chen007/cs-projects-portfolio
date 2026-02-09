public class backgroundUpdate implements Runnable {
        
        private travelUpdate traveler;
        private volatile boolean running = true;
        private trail stopCode = new trail();
        private int doesNothing;
       public backgroundUpdate(int month, int food){
               traveler = new travelUpdate(month,food);
       }
       public backgroundUpdate(){
            doesNothing=0;
        }
        public void stop(){
            running=false;
        }
        public void cont(){
            running=true;
        }
        
        //@Override
        public void run() {
            while (!Thread.currentThread().isInterrupted() &&running) {
                System.out.print("\u000C");
                System.out.println("Enter 'stop' to seize situation:");
                System.out.print(traveler);
                try {
                    if(traveler.getDistance()==900){
                        System.out.println("Journey end");
                        System.out.println("Input any character to stop program");
                        stopCode.stopCheckInput();
                        stop();
                        Thread.currentThread().interrupt();
                    }
                    else{
                        traveler.updateInfo();
                    }
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
}



