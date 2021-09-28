package savegame;

public class SavableContainer
{

	public int index;
	public int id;
	public int damage;
	public int meta;
	public int count;
	public SavableContainer()
	{
		
	}
	public SavableContainer(int newId, int newCount, int newDamage, int newMeta)
	{
		this.id = newId;
		this.count = newCount;
		this.damage = newDamage;
		this.meta = newMeta;
	}
}
