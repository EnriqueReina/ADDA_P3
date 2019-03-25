package tipos;

public class Monumento {
	private String name;
		
	public static Monumento create(String formato[])
	{
		return new Monumento(formato[0]);
	}
	
	public static Monumento create(String nombre)
	{
		return new Monumento(nombre);
	}
	
	public static Monumento create()
	{
		return new Monumento(null);
	}
	
	public Monumento(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Monumento other = (Monumento) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
