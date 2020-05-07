public class PVector {
	public float x, y;
	
	public PVector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public PVector(PVector v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof PVector) {
			PVector v = (PVector) obj;
			return (this.x == v.x) && (this.y == v.y);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ") ";
	}
	
	public void add(PVector v) {
		this.x += v.x;
		this.y += v.y;
	}
	
	public void sub(PVector v) {
		this.x -= v.x;
		this.y -= v.y;		
	}
	
	public void mult(float factor) {
		this.x *= factor;
		this.y *= factor;		
	}
	
	public void div(float divisor) {
		this.x /= divisor;
		this.y /= divisor;
	}
	
	public static PVector add(PVector v1, PVector v2) {
		PVector sum =  new PVector(v1);
		sum.add(v2);
		return sum;
	}
	
	public static PVector sub(PVector v1, PVector v2) {
		PVector diff =  new PVector(v1);
		diff.sub(v2);
		return diff;
	}
	
	public static PVector mult(PVector v, float factor) {
		PVector stretch =  new PVector(v);
		stretch.mult(factor);
		return stretch;		
	}
	
	public static PVector div(PVector v, float divisor) {
		PVector squash =  new PVector(v);
		squash.div(divisor);
		return squash;		
	}
	
	public static PVector random(float minLength, float maxLength) {
		float randomAngle = (float) (Math.random() * 2 * Math.PI);
		float randomLength = (float) (Math.random() * Math.abs(maxLength - minLength) + minLength);
		float randomX = (float) (Math.cos(randomAngle) * randomLength);
		float randomY = (float) (Math.sin(randomAngle) * randomLength);
		return new PVector(randomX, randomY);
	}
}
