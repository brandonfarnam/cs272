package edu.orangecoastcollege.cs272.model;

public class Equipment {
	private int mId;
	private String mName;
	private int mStrength;
	private int mDexterity;
	private int mIntellect;
	private int mLevel;
	
	public Equipment(int mId, String mName, int mStrength, int mDexterity, int mIntellect, int mLevel) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mStrength = mStrength;
		this.mDexterity = mDexterity;
		this.mIntellect = mIntellect;
		this.mLevel = mLevel;
	}
	public Equipment(){
		mId =1; 
		mStrength=1;
		mDexterity=2;
		mIntellect=3;
		mLevel=1;
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
		result = prime * result + mId;
		result = prime * result + mIntellect;
		result = prime * result + mLevel;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mStrength;
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
		Equipment other = (Equipment) obj;
		if (mDexterity != other.mDexterity)
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
		return true;
	}
	
	@Override
	public String toString() {
		return "Equipment [mId=" + mId + ", mName=" + mName + ", mStrength=" + mStrength + ", mDexterity=" + mDexterity
				+ ", mIntellect=" + mIntellect + ", mLevel=" + mLevel + "]";
	}
	
	
	
	
	
}
