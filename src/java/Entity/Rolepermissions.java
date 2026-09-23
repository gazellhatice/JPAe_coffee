package Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Hatice
 */

@Entity
@Table(name = "rolepermissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolepermissions.findAll", query = "SELECT r FROM Rolepermissions r"),
    @NamedQuery(name = "Rolepermissions.findByRolepermissionsId", query = "SELECT r FROM Rolepermissions r WHERE r.rolepermissionsId = :rolepermissionsId")})
public class Rolepermissions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rolepermissions_id")
    private Long rolepermissionsId;
    
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleId;
    
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    @ManyToOne(optional = false)
    private Permissions permissionId;

    public Rolepermissions() {
    }

    public Rolepermissions(Long rolepermissionsId) {
        this.rolepermissionsId = rolepermissionsId;
    }

    public Long getRolepermissionsId() {
        return rolepermissionsId;
    }

    public void setRolepermissionsId(Long rolepermissionsId) {
        this.rolepermissionsId = rolepermissionsId;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public Permissions getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permissions permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolepermissionsId != null ? rolepermissionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Rolepermissions)) {
            return false;
        }
        Rolepermissions other = (Rolepermissions) object;
        if ((this.rolepermissionsId == null && other.rolepermissionsId != null) || (this.rolepermissionsId != null && !this.rolepermissionsId.equals(other.rolepermissionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Rolepermissions[ rolepermissionsId=" + rolepermissionsId + " ]";
    }
    
}
