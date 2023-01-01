package sserver_program_rpc;
import java.io.Serializable;
import java.util.Objects;

public class CalculateRpcRequest implements Serializable {

   // private static final long serialVersionUID = 7503710091945320739L;

    /**
	 * 
	 */
	private static final long serialVersionUID = 5329051489837184418L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String method;
    private int a;
    private int b;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

	@Override
	public String toString() {
		return "CalculateRpcRequest [method=" + method + ", a=" + a + ", b=" + b + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, method);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalculateRpcRequest other = (CalculateRpcRequest) obj;
		return a == other.a && b == other.b && Objects.equals(method, other.method);
	}

}
