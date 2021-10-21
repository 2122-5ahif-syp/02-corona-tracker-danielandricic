package at.htl.repository;

import at.htl.entity.Visitor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public class VisitorRespository implements PanacheRepository<Visitor> {

    public VisitorRespository() {

    }

    @Transactional
    public boolean addVisitor(Visitor vs)
    {
        if(!isPersistent(vs)) {
            persistAndFlush(vs); // Um das Speichern des neuen Eintrags gleich nachdem Einfügen auszuführen.
            return true;
        }

        return false;
    }

    public Visitor getVisitorById(Long id) {
        return (Visitor) find(String.valueOf(id));
    }

    public List<Visitor> getAllVisitors() {
        return Collections.unmodifiableList(listAll());
    }

    @Transactional
    public Visitor updateVisitor(Long id, Visitor newVs) {
        var oldVs = getVisitorById(id);
        if(oldVs != null) {
            oldVs.setFirstname(newVs.getFirstname());
            oldVs.setLastname(newVs.getLastname());
            oldVs.setEmail(newVs.getEmail());
            oldVs.setPhoneNumber(newVs.getPhoneNumber());
            flush();
            return oldVs;
        }

        return null;
    }

    @Transactional
    public Visitor deleteVisitor(Long id) {
        var vs = getVisitorById(id);
        if(vs != null) {
            delete(vs);
            flush();
            return vs;
        }

        return null;
    }
}
