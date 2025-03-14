//Name: Jeffrey Ma
//Date: May 11th, 2022
//Description: Creates a laptop object
//Major Skills: Setters and Getters, Constructor method, toString
//Additional Features: none
//Areas of Concerns: none	
//Contribution: Jeffrey Ma 100%

// template class
public class Laptop {

	private int number;
	private String brand;
	private String laptopModel;
	private String type;
	private double price;
	private String brandCPU;
	private String modelCPU;
	private int cores;
	private double speed;
	private int ram;
	private int storage;
	private String gpu;
	private int ports;
	private String system;
	private double display;
	private int widthResolution;
	private int heightResolution;
	private double weight;
	private boolean touchscreen;
	private double qualityRating;
	private double speedRating;
	private double memoryRating;
	private double displayRating;
	private double overallRating;
	private String hyperlink;
	private String imageURL;

	// constructor
	public Laptop(int number, String brand, String laptopModel, String type, double price, String brandCPU,
			String modelCPU, int cores, double speed, int ram, int storage, String gpu, int ports, String system,
			double display, int widthResolution, int heightResolution, double weight, boolean touchscreen,
			double qualityRating, double speedRating, double memoryRating, double displayRating, double overallRating,
			String hyperlink, String imageURL) {
		super();
		this.number = number;
		this.brand = brand;
		this.laptopModel = laptopModel;
		this.type = type;
		this.price = price;
		this.brandCPU = brandCPU;
		this.modelCPU = modelCPU;
		this.cores = cores;
		this.speed = speed;
		this.ram = ram;
		this.storage = storage;
		this.gpu = gpu;
		this.ports = ports;
		this.system = system;
		this.display = display;
		this.widthResolution = widthResolution;
		this.heightResolution = heightResolution;
		this.weight = weight;
		this.touchscreen = touchscreen;
		this.qualityRating = qualityRating;
		this.speedRating = speedRating;
		this.memoryRating = memoryRating;
		this.displayRating = displayRating;
		this.overallRating = overallRating;
		this.hyperlink = hyperlink;
		this.imageURL = imageURL;
	}

	// setters and getters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrandCPU() {
		return brandCPU;
	}

	public void setBrandCPU(String brandCPU) {
		this.brandCPU = brandCPU;
	}

	public String getModelCPU() {
		return modelCPU;
	}

	public void setModelCPU(String modelCPU) {
		this.modelCPU = modelCPU;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public int getPorts() {
		return ports;
	}

	public void setPorts(int ports) {
		this.ports = ports;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public double getDisplay() {
		return display;
	}

	public void setDisplay(double display) {
		this.display = display;
	}

	public int getWidthResolution() {
		return widthResolution;
	}

	public void setWidthResolution(int widthResolution) {
		this.widthResolution = widthResolution;
	}

	public int getHeightResolution() {
		return heightResolution;
	}

	public void setHeightResolution(int heightResolution) {
		this.heightResolution = heightResolution;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isTouchscreen() {
		return touchscreen;
	}

	public void setTouchscreen(boolean touchscreen) {
		this.touchscreen = touchscreen;
	}

	public double getQualityRating() {
		return qualityRating;
	}

	public void setQualityRating(double qualityRating) {
		this.qualityRating = qualityRating;
	}

	public double getSpeedRating() {
		return speedRating;
	}

	public void setSpeedRating(double speedRating) {
		this.speedRating = speedRating;
	}

	public double getMemoryRating() {
		return memoryRating;
	}

	public void setMemoryRating(double memoryRating) {
		this.memoryRating = memoryRating;
	}

	public double getDisplayRating() {
		return displayRating;
	}

	public void setDisplayRating(double displayRating) {
		this.displayRating = displayRating;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Laptop [number=" + number + ", brand=" + brand + ", laptopModel=" + laptopModel + ", type=" + type
				+ ", price=" + price + ", brandCPU=" + brandCPU + ", modelCPU=" + modelCPU + ", cores=" + cores
				+ ", speed=" + speed + ", ram=" + ram + ", storage=" + storage + ", gpu=" + gpu + ", ports=" + ports
				+ ", system=" + system + ", display=" + display + ", widthResolution=" + widthResolution
				+ ", heightResolution=" + heightResolution + ", weight=" + weight + ", touchscreen=" + touchscreen
				+ ", qualityRating=" + qualityRating + ", speedRating=" + speedRating + ", memoryRating=" + memoryRating
				+ ", displayRating=" + displayRating + ", overallRating=" + overallRating + ", hyperlink=" + hyperlink
				+ ", laptopImage=" + imageURL + "]";
	}

}