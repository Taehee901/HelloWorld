/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]

console.log(cartItems);

	


const basket = {
	// 장바구니 수량 변경.
	//아래코드는아닌것같아.
	changePNum() {
		const upcart = document.querySelectorAll('.fas.fa-arrow-alt-circle-up.up');
			upcart.forEach(upcart =>{
				upcart.addEventListener('click',function(){
					cartItems.forEach(cart=>{
					console.log(cart.qty);
					cart.qty++;						
					})
				})
			})
		const downcart = document.querySelectorAll('.fas.fa-arrow-alt-circle-down.down');
			downcart.forEach(downcart=>{
				downcart.addEventListener('click',function(){
					cartItems.forEach(cart=>{
						console.log(cart.qty);
						cart.qty--;
					})
				})					
			})
	},
	// 상품삭제.
	delItem(e){
		//e 없어 target하면 오류가 발생->e.target.parentElement.parentElement.parentElement.remove(); ,x
		//e.target;
		//console.log(e.target);
		 e.target;
	},
	// 선택상품삭제.
	delCheckedItem() {
		

	},
	// 장바구니 비우기.
	delAllItem() {

	}
}

//목록 상품나오게 하는거
cartItems.forEach(carts=>{
	const cartList = `<div class="row data" data-id="1" >
			<div class="subdiv">
	        <div class="check"id="charts"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
	        <div class="img"><img src="./images/basket1.jpg" width="60">${carts.image}</div>
	        <div class="pname"> <span>${carts.itemName}-${carts.itemId}</span></div>
	    </div>
	    <div class="subdiv">
	        <div class="basketprice">
	            <input type="hidden" name="p_price${carts.itemId}" id="p_price1" class="p_price" value="${carts.price}">${carts.price}원
	        </div>
	        <div class="num">
	            <div class="updown">
	                <input type="text" name="p_num1" id="p_num1${carts.itemId}" size="2" maxlength="4" class="p_num" value="${carts.qty}"
	                    onkeyup="javascript:basket.changePNum();">
	                <span onclick="javascript:basket.changePNum();">
	                    <i class="fas fa-arrow-alt-circle-up up"></i></span>
	                <span onclick="javascript:basket.changePNum();">
	                    <i class="fas fa-arrow-alt-circle-down down"></i> </span>
	            </div>
	        </div>
	        <div class="sum">${carts.price * carts.qty}</div>
	    </div>
	    <div class="subdiv">
	        <div class="basketcmd">
	            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(e);">삭제</a>
	        </div>
		</div>
	</div>`;
	document.querySelector('#basket') .insertAdjacentHTML('beforeend',cartList);
})
