package src.main;
import src.main.*;
import java.util.ArrayList;
import java.util.List;


public abstract class NarrativeLoop{
    protected final List<SystemWhole> emulation = new ArrayList<>();
    protected final List<SystemWhole> simulacra = new ArrayList<>();
    protected final List<SystemWhole> simulation = new ArrayList<>();
/**
 * wipeNarrativeLoops method, clears all narrative loop lists
 */
    public void wipeNarrativeLoops(){
        emulation.clear();
        simulacra.clear();
        simulation.clear();
    }
    /**
     * 
     * @param emulationContext emulation list
     * @param simulacraContext simulacra list
     * adds systemwhole based on the realm and if the kind is already in that list
     */
    public final void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        for (SystemWhole systemwhole : emulationContext){
            for (Machine machine : systemwhole.reify()){
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                
                if (realm == Realm.EMULATION && containsKind(emulation, machine.getKind()) == false){
                    emulation.add(systemwhole);
                }
                
            }
        }
        for (SystemWhole systemwhole : simulacraContext){
            for (Machine machine : systemwhole.reify()){
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                if (realm == Realm.SIMULACRA && containsKind(simulacra, machine.getKind()) == false){
                    simulacra.add(systemwhole);
                }
                else if (realm == Realm.SIMULATION && containsKind(simulation, machine.getKind()) == false){
                    simulation.add(systemwhole);
                }

            }
        }
    }

    /**
     * 
     * @param kind kind of systemwhole
     * @param emulationContext emulation list
     * @param simulacraContext simulacra list
     * @return the realm that the kind and list are in
     */
    private final Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        if (isInContext(kind, emulationContext) == true && isInContext(kind, simulacraContext) == true){
            return Realm.SIMULATION;
        }
        else if (isInContext(kind, simulacraContext)){
            return Realm.SIMULACRA;
        }
        else{
            return Realm.EMULATION;
        }
        
    }
    /**
     * 
     * @param kind kind of systemwhole
     * @param context systemwhole list
     * @return true or false, if the kind in machine matches the kind in systemwhole
     */
    private final boolean isInContext(String kind, SystemWhole[] context){
        for (SystemWhole systemwhole : context){
            List<Machine> list = systemwhole.reify();
            for (Machine machine : list){
                if ((machine.getKind()).equals(kind)){
                    return true;
                }
            }
        }
        return false;
        
    }
    /**
     * 
     * @param list systemwhole list
     * @param kind systemwhole kind
     * @return true or false, if the kind in machine matches the kind in systemwhole
     */
    private final boolean containsKind(List<SystemWhole> list, String kind){
        for (SystemWhole systemwhole : list){
            for (Machine machine : systemwhole.reify()){ 
                if ((machine.getKind()).equals(kind)){
                    return true;
                }
            }
        }
        return false;
    }
}