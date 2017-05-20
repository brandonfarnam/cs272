package edu.orangecoastcollege.cs272.model;

public class Player {
	private int mId;
	private String mName;
	private int mStrength;
	private int mDexterity;
	private int mIntellect;
	//health, xp, level, equipment
	private int mHealth;
	private double mXP;
	private int mLevel;
	//id, name, strength, dexterity,health,xp,level,equipment
	public Player(int mId, String mName, int mStrength, int mDexterity, int mIntellect, int mHealth, double mXP,
			int mLevel ) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mStrength = mStrength;
		this.mDexterity = mDexterity;
		this.mIntellect = mIntellect;
		this.mHealth = mHealth;
		this.mXP = mXP;
		this.mLevel = mLevel;
	}
	public Player()
	{
		mId = 1;
		mStrength = 5;
		mDexterity = 5;
		mIntellect = 5;
		mHealth = 25;
	}
	public int getId() {
		return mId;
	}
	public void setId(int mId) {
		this.mId = mId;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public int getStrength() {
		return mStrength;
	}
	public void setStrength(int mStrength) {
		this.mStrength = mStrength;
	}
	public int getDexterity() {
		return mDexterity;
	}
	public void setDexterity(int mDexterity) {
		this.mDexterity = mDexterity;
	}
	public int getIntellect() {
		return mIntellect;
	}
	public void setIntellect(int mIntellect) {
		this.mIntellect = mIntellect;
	}
	public int getHealth() {
		return mHealth;
	}
	public void setHealth(int mHealth) {
		this.mHealth = mHealth;
	}
	public double getXP() {
		return mXP;
	}
	public void setXP(double mXP) {
		this.mXP = mXP;
	}
	public int getLevel() {
		return mLevel;
	}
	public void setLevel(int mLevel) {
		this.mLevel = mLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDexterity;
		result = prime * result + mHealth;
		result = prime * result + mId;
		result = prime * result + mIntellect;
		result = prime * result + mLevel;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mStrength;
		long temp;
		temp = Double.doubleToLongBits(mXP);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Player other = (Player) obj;
		if (mDexterity != other.mDexterity)
			return false;
		if (mHealth != other.mHealth)
			return false;
		if (mId != other.mId)
			return false;
		if (mIntellect != other.mIntellect)
			return false;
		if (mLevel != other.mLevel)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mStrength != other.mStrength)
			return false;
		if (Double.doubleToLongBits(mXP) != Double.doubleToLongBits(other.mXP))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Player [mId=" + mId + ", mName=" + mName + ", mStrength=" + mStrength + ", mDexterity=" + mDexterity
				+ ", mIntellect=" + mIntellect + ", mHealth=" + mHealth + ", mXP=" + mXP + ", mLevel=" + mLevel + "]";
	}
	
	
}