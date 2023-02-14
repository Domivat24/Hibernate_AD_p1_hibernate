package org.iesabastos.dam.datos.IJG;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
	@Id
	private short emp_no;
	private String nombre;
	private String oficio;
	private Date fecha_alta;
	private Float salario;
	private Float comision;

	public short getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(short emp_no) {
		this.emp_no = emp_no;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public Float getComision() {
		return comision;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}


	public Empleado() {
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_NO")
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"emp_no=" + emp_no +
				", nombre='" + nombre + '\'' +
				", oficio='" + oficio + '\'' +
				", fecha_alta=" + fecha_alta +
				", salario=" + salario +
				", comision=" + comision;
	}
}
