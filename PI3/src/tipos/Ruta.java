package tipos;

public class Ruta {
	
	private Monumento from, to;
	private String nombreRuta;
	private Double tiempo;

	
	public static Ruta create(Monumento from, Monumento to, String formato[])
	{
		return new Ruta(from,to,formato[2],Double.parseDouble(formato[3]));
	}
	
	public static Ruta create()
	{
		return new Ruta(null,null,"",null);
	}
	
	public Ruta(Monumento from, Monumento to, String nombreRuta, Double tiempo) {
		super();
		this.from = from;
		this.to = to;
		this.nombreRuta = nombreRuta;
		this.tiempo = tiempo;
	}

	public Monumento getFrom() {
		return from;
	}

	public void setFrom(Monumento from) {
		this.from = from;
	}

	public Monumento getTo() {
		return to;
	}

	public void setTo(Monumento to) {
		this.to = to;
	}

	public String getNombreRuta() {
		return nombreRuta;
	}

	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void settiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((nombreRuta == null) ? 0 : nombreRuta.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruta other = (Ruta) obj;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (nombreRuta == null) {
			if (other.nombreRuta != null)
				return false;
		} else if (!nombreRuta.equals(other.nombreRuta))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  ""+from;
	}
	
	

}
