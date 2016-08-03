package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT a FROM Usuario a")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario", unique=true, nullable=false)
	private int idUsuario;

	@Column(name="contrasena", nullable=false, length=30)
	private String contrasena;

	@Column(name="nombre", nullable=false, length=50)
	private String nombreUsuario;
	
	@Column(name="cargo", nullable=false, length=15)
	private String cargo;
	
	@Column(name="token", nullable=false, length=100)
	private String token;
	
	public Usuario() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}