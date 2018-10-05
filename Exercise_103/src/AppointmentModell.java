
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class AppointmentModell extends AbstractListModel{
    
    private ArrayList<Appointment> appointments=new ArrayList<>();
    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int index) {
       return appointments.get(index);
    }
    
    public void add(Appointment a){
        appointments.add(a);
        fireIntervalAdded(appointments.size()-1, appointments.size()-1, 0);
    }
    
    public void remove(int i){
        appointments.remove(i);
        fireContentsChanged(i, i, i);
    }
    
}
