package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.AddressDAO;
import org.tarena.dang.entity.Address;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Factory;

public class LoadAddressAction extends BaseAction {
	// input
	private int id;

	// output
	private int[] ids;
	private boolean cartStatus = false;

	public int getId() {
		return id;
	}

	public boolean isCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String[] fullAddresses;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;

	public String init() throws Exception {
		// TODO Auto-generated method stub
		CartService cart = CartFactory.getInstance(session, request);
		if (cart.getBuyPros().size() == 0) {
			cartStatus = true;
			return super.execute();
		}

		User user = (User) session.get("user");
		AddressDAO addressDao = (AddressDAO) Factory.getInstance("AddressDAO");
		List<Address> addresses = addressDao.findByUserId(user.getId());
		int size = addresses.size();
		ids = new int[size];
		fullAddresses = new String[size];
		for (int i = 0; i < size; i++) {
			ids[i] = addresses.get(i).getId();
			fullAddresses[i] = addresses.get(i).getFullAddress();
		}
		return super.execute();
	}

	public String load() throws Exception {
		AddressDAO addressDao = (AddressDAO) Factory.getInstance("AddressDAO");
		Address address = addressDao.findById(id);
		receiveName = address.getReceiveName();
		fullAddress = address.getFullAddress();
		postalCode = address.getPostalCode();
		mobile = address.getMobile();
		phone = address.getPhone();
		return super.execute();
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String[] getFullAddresses() {
		return fullAddresses;
	}

	public void setFullAddresses(String[] fullAddresses) {
		this.fullAddresses = fullAddresses;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
