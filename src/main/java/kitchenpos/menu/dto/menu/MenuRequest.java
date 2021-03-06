package kitchenpos.menu.dto.menu;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRequest {

	private String name;
	private BigDecimal price;
	private Long menuGroupId;
	private List<MenuProductRequest> menuProductRequests;

	protected MenuRequest() {
	}

	public MenuRequest(final String name, final BigDecimal price, final Long menuGroupId,
		final List<MenuProductRequest> menuProductRequests) {
		this.name = name;
		this.price = price;
		this.menuGroupId = menuGroupId;
		this.menuProductRequests = menuProductRequests;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public Long getMenuGroupId() {
		return menuGroupId;
	}

	public void setMenuGroupId(final Long menuGroupId) {
		this.menuGroupId = menuGroupId;
	}

	public List<MenuProductRequest> getMenuProductRequests() {
		return menuProductRequests;
	}

	public void setMenuProductRequests(final List<MenuProductRequest> menuProductRequests) {
		this.menuProductRequests = menuProductRequests;
	}

	public List<Long> getProductIds() {
		return this.menuProductRequests.stream()
			.map(MenuProductRequest::getProductId)
			.collect(Collectors.toList());
	}
}
