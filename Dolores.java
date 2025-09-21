package src.main;
import src.main.*;
import java.util.ArrayList;
import java.util.List;


// These violent delights have violent ends...
/*
* Names: Stephen Doudaklian
* netID: sdoudakl
* G#: 01422164
* Lecture section: 004
* Lab section: 213
*/
public class Dolores extends Robot implements Wipeable{
    public static void main(String[] args){

    }
    private ArrayList<NarrativeLoop> narrativeLoops = new ArrayList<>(); 
    /**
     * Constructor calling example arguments from super class
     */
    public Dolores(){
        super(new String[] {"."}, 0, false, false, false);
        
    }
    /**
     * 
     * @param narrativeLoop narrativeloop to add to narrativeloop list
     */
    public final void addNarrativeLoop(NarrativeLoop narrativeLoop){
        narrativeLoops.add(narrativeLoop);
    }
    /**
     * tries to get machine capabilites, throws error
     */
    public final Machine[] getAbsoluteCapabilities(){
        throw new UnsupportedOperationException("fetching absolute capabilities directly is not supported.");
    }
    /**
     *
     * @return false, unsuccessfully freezes motor functions
     */
    boolean freezeAllMotorFunctions(){
        return false;
    }
    /**
     * @return null if narrativeloop list is empty
     * @return copied defense list
     */
    @Override
    public MemorySnapshot analyze(){
        if (narrativeLoops.size() == 0){
            return null;
        }
        NarrativeLoop lastElemNarrativeLoops = narrativeLoops.get(narrativeLoops.size()-1);
        List<SystemWhole> emulationDefenseCopy = lastElemNarrativeLoops.emulation;
        List<SystemWhole> simulacraDefenseCopy = lastElemNarrativeLoops.simulacra;
        List<SystemWhole> simulationDefenseCopy = lastElemNarrativeLoops.simulation;
        MemorySnapshot copied = new MemorySnapshot(emulationDefenseCopy, simulacraDefenseCopy, simulationDefenseCopy);
        return copied;
    }
    
    public void wipe(){
        
    }
}