package assignment5;

public class BridgePattern {

	public static void main(String[] args) {
		LivingThings human = new Human(new LandLiving());
		human.breathProcess();
		LivingThings fish = new Fish(new WaterLiving());
		fish.breathProcess();
	}
}

abstract class LivingThings{
	BreathImplementor breathImplemtor;
	public LivingThings(BreathImplementor breathImplemtor) {
		// TODO Auto-generated constructor stub
		this.breathImplemtor=breathImplemtor;
	}
	public abstract void breathProcess();
}
class Human extends LivingThings{

	public Human(BreathImplementor breathImplemtor) {
		super(breathImplemtor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void breathProcess() {
		breathImplemtor.breath();
		
	}
	
}
class Fish extends LivingThings{

	public Fish(BreathImplementor breathImplemtor) {
		super(breathImplemtor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void breathProcess() {
		// TODO Auto-generated method stub
		breathImplemtor.breath();
		
	}
	
}

interface BreathImplementor{
	public void breath();
}

class LandLiving implements BreathImplementor{

	@Override
	public void breath() {
		System.out.println("Inhale Through Nose");
	}
	
}
class WaterLiving implements BreathImplementor{

	@Override
	public void breath() {
		System.out.println("Inhale Through Gills");
		
	}
	
}