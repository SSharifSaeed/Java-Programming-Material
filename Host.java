package src.main;
import src.main.*;
import java.util.ArrayList;
import java.util.List;

// narrative loop = list of systemwholes
public class Host extends Dolores{
    private final NarrativeLoop narrativeLoop;
    /**
     * 
     * @param narrativeloop narrativeloop class
     * calls super class
     * adds narrativeloop param to narrativeloop list
     */
    public Host(NarrativeLoop narrativeloop){
        super();
        this.narrativeLoop = narrativeloop;
        addNarrativeLoop(narrativeloop);
    }
    /**
     * Successfully freezes motor functions
     * @return true
     */
    public boolean freezeAllMotorFunctions(){
        return true;
    }
    /**
     * @return false if narrativeloop is empty
     * @return memorysnapshot object with narrativeloop realms
     */
    public MemorySnapshot analyze(){
        if (narrativeLoop == null){
            return null;
        }
        return new MemorySnapshot(narrativeLoop.emulation, narrativeLoop.simulacra, narrativeLoop.simulation);
    }
    /**
     * wipes narrativeloop list
     */
    public void wipe(){
        narrativeLoop.wipeNarrativeLoops();
    }
    /**
     * 
     * @return true, successfully freezes motor functions
     */
    public boolean freeze(){
        freezeAllMotorFunctions();
        return true;
    }

}