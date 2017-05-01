package pl.motyka.mateusz.klaser;

import java.math.BigDecimal;
import java.util.Date;

public class Pokemon {

	private Long catalogNumber;//
	private CardType cardType;//
	private Rarity rarity;//
	private int HP;//
	private String attackDescription;//
	private int attackCost;//
	private String attackDescription2;//
	private int attackCost2;//
	private String retreatCost;//
	private String weakness;//
	private String resistance;//
	private String name;//
	private Date purchaseDate;
	private BigDecimal purchasePrice;
	private Status status;//
	private EnergyType energyType;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Pokemon pokemon = (Pokemon) o;

		if (catalogNumber != pokemon.catalogNumber)
			return false;
		if (HP != pokemon.HP)
			return false;
		if (attackCost != pokemon.attackCost)
			return false;
		if (energyType != pokemon.energyType)
			return false;
		if (attackDescription != null ? !attackDescription.equals(pokemon.attackDescription)
				: pokemon.attackDescription != null)
			return false;
		if (attackCost2 != pokemon.attackCost2)
			return false;
		if (attackDescription2 != null ? !attackDescription2.equals(pokemon.attackDescription2)
				: pokemon.attackDescription2 != null)
			return false;
		if (name != null ? !name.equals(pokemon.name) : pokemon.name != null)
			return false;
		if (retreatCost != pokemon.retreatCost)
			return false;
		if (weakness != pokemon.weakness)
			return false;
		if (resistance != pokemon.resistance)
			return false;
		if (rarity != pokemon.rarity)
			return false;
		if (cardType != pokemon.cardType)
			return false;
		if (purchasePrice != null ? !purchasePrice.equals(pokemon.purchasePrice) : pokemon.purchasePrice != null)
			return false;
		if (purchaseDate != null ? !purchaseDate.equals(pokemon.purchaseDate) : pokemon.purchaseDate != null)
			return false;
		return status == pokemon.status;
	}

	@Override
	public int hashCode() {
		int result = (int) (catalogNumber ^ (catalogNumber >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (attackDescription != null ? attackDescription.hashCode() : 0);
		result = 31 * result + (attackDescription2 != null ? attackDescription2.hashCode() : 0);
		result = 31 * result + (int) (HP ^ (HP >>> 32));
		result = 31 * result + (int) (attackCost ^ (attackCost >>> 32));
		result = 31 * result + (int) (attackCost2 ^ (attackCost2 >>> 32));
		result = 31 * result + (weakness != null ? weakness.hashCode() : 0);
		result = 31 * result + (retreatCost != null ? retreatCost.hashCode() : 0);
		result = 31 * result + (resistance != null ? resistance.hashCode() : 0);
		result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
		result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
		result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
		result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (energyType != null ? energyType.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Pokemon [" + name + " zywiol: " + energyType + " typ pokemona: " + cardType + ", ilosc HP: " + HP + ", rzadkosc: " + rarity
				+ ", koszt pierwszego ataku: " + attackCost + ", opis pierwszego ataku: "
				+ attackDescription + ", koszt drugiego ataku: " + attackCost2 + ", opis drugiego ataku: "
				+ attackDescription2 + ", slabosc: " + weakness + ", odpornosc: " + resistance + ", koszt odwrotu: "
				+ retreatCost + ", numer katalogowy: " + catalogNumber + " status: " + status + " data nabycia: "
				+ purchaseDate + " kwota nabycia: " + purchasePrice + "]";
	}

	public Long getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(Long catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttackDescription2() {
		return attackDescription2;
	}

	public void setAttackDescription2(String attackDescription2) {
		this.attackDescription2 = attackDescription2;
	}

	public int getAttackCost2() {
		return attackCost2;
	}

	public void setAttackCost2(int attackCost2) {
		this.attackCost2 = attackCost2;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public String getAttackDescription() {
		return attackDescription;
	}

	public void setAttackDescription(String attackDescription) {
		this.attackDescription = attackDescription;
	}

	public int getAttackCost() {
		return attackCost;
	}

	public void setAttackCost(int attackCost) {
		this.attackCost = attackCost;
	}

	public String getRetreatCost() {
		return retreatCost;
	}

	public void setRetreatCost(String retreatCost) {
		this.retreatCost = retreatCost;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public String getResistance() {
		return resistance;
	}

	public void setResistance(String resistance) {
		this.resistance = resistance;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}	

	public EnergyType getEnergyType() {
		return energyType;
	}

	public void setEnergyType(EnergyType energyType) {
		this.energyType = energyType;
	}

	public static Pokemon producePokemon(Long catalogNumber, EnergyType energyType, CardType cardType, Rarity rarity, int hP,
			String attackDescription, int attackCost, String attackDescription2, int attackCost2, String retreatCost,
			String weakness, String resistance, String name, Status status, Date purchaseDate,
			BigDecimal purchasePrice) {

		Pokemon pokemon = new Pokemon();
		pokemon.catalogNumber = catalogNumber;
		pokemon.energyType = energyType;
		pokemon.cardType = cardType;
		pokemon.rarity = rarity;
		pokemon.HP = hP;
		pokemon.attackDescription = attackDescription;
		pokemon.attackCost = attackCost;
		pokemon.attackDescription2 = attackDescription2;
		pokemon.attackCost2 = attackCost2;
		pokemon.retreatCost = retreatCost;
		pokemon.weakness = weakness;
		pokemon.resistance = resistance;
		pokemon.name = name;
		pokemon.status = status;
		pokemon.purchaseDate = purchaseDate;
		pokemon.purchasePrice = purchasePrice;
		return pokemon;
	}
}
