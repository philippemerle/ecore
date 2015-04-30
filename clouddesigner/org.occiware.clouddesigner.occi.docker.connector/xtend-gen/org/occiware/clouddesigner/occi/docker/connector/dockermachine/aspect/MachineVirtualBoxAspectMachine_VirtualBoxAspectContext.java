package org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect;

import java.util.Map;
import org.occiware.clouddesigner.occi.docker.Machine_VirtualBox;
import org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties;

@SuppressWarnings("all")
public class MachineVirtualBoxAspectMachine_VirtualBoxAspectContext {
  public final static MachineVirtualBoxAspectMachine_VirtualBoxAspectContext INSTANCE = new MachineVirtualBoxAspectMachine_VirtualBoxAspectContext();
  
  public static MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties getSelf(final Machine_VirtualBox _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Machine_VirtualBox, MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties> map = new java.util.WeakHashMap<org.occiware.clouddesigner.occi.docker.Machine_VirtualBox, org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties>();
  
  public Map<Machine_VirtualBox, MachineVirtualBoxAspectMachine_VirtualBoxAspectProperties> getMap() {
    return map;
  }
}
