package fresher.Team3.DTO;

public class ReviewDTO {
	private Integer productId;
	private String userName;
	private String content;
	private Integer rate;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "ReviewDTO [productId=" + productId + ", userName=" + userName + ", content=" + content + ", rate="
				+ rate + "]";
	}
	public ReviewDTO(Integer productId, String userName, String content, Integer rate) {
		super();
		this.productId = productId;
		this.userName = userName;
		this.content = content;
		this.rate = rate;
	}
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
