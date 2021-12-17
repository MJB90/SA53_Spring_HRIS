package lasp.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "user")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String Password;
	
	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="reportsTo")
	private Integer ReportsTo;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "role_id"))
	private Collection<Role> roles;

//	@OneToMany(targetEntity = LeaveApplied.class,cascade = CascadeType.ALL,mappedBy = "user")
//	private List<LeaveApplied> leaveAppliedList;
//	@OneToMany(targetEntity = LeaveEntitled.class,cascade = CascadeType.ALL,mappedBy = "user")
//	private List<LeaveEntitled> leaveEntitledList;

	
	public User() {
		super();
	}

	public User(Long id, String email, String password, String firstName, String lastName,
			Integer reportsTo, Collection<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		ReportsTo = reportsTo;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Integer getReportsTo() {
		return ReportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		ReportsTo = reportsTo;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}