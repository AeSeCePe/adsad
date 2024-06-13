package restobar.biz.platform.u202210697.attention.domain.model.entities;

import biz.hotel.platform.u202210846.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    public Client() {
        this.fullname = "";
    }

    public Client(String fullname) {
        this.fullname = fullname;
    }
}
