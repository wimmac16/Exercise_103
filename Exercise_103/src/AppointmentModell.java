
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class AppointmentModell extends AbstractListModel {

    private final ArrayList<Appointment> appointments = new ArrayList<>();

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Appointment getElementAt(int index) {
        return appointments.get(index);
    }

    public void add(Appointment a) {
        appointments.add(a);
        fireIntervalAdded(appointments.size() - 1, appointments.size() - 1, 0);

    }

    public void remove(int i) {
        appointments.remove(i);
        fireContentsChanged(i, i, i);
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Object o;
            while ((o = ois.readObject()) != null) {
                appointments.add((Appointment) o);
            }
        } catch (EOFException eofExc) {

        }

    }

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Appointment a : appointments) {
            oos.writeObject(a);
        }
        oos.flush();

    }

    public void update(int i, Appointment a) {
        appointments.remove(i);
        appointments.add(a);
        fireContentsChanged(a, i, i);

    }

}
