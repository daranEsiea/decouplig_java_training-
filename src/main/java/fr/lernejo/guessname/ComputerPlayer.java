package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("computer");
    long min = 0;
    long max = 100;
    boolean lowerOrGreater = true;
    boolean isFirstTurn = true;

    @Override
    public long askNextGuess() {
        long mean = (this.max+this.min)/2;

        if(this.isFirstTurn){
            this.isFirstTurn = false;
        }else{
            if(lowerOrGreater){ // plus petit
                this.max = mean - 1;
                //this.logger.log(" Max : " + this.max );
            }else{ // plus grand

                this.min = mean + 1;
                //this.logger.log(" Min : " + this.min );
            }
        }
        this.logger.log("Max : " + this.max);
        this.logger.log("Min : " + this.min);
        mean = (this.max+this.min)/2;

        this.logger.log("Computer saisi : " + mean);
        return mean;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.lowerOrGreater = lowerOrGreater;
        if(lowerOrGreater){
            this.logger.log("Plus petit");
        }else{
            this.logger.log("Plus grand");
        }
    }
}