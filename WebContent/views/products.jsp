<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${products}" var="product">
	<div class="item">
		<h1>${product.name}</h1>
		<img src="${product.image}" alt="">
		<div style="display: inline-block; vertical-align: top; width: 10em;">
			${product.description}
			<p style="vertical-align: bottom; text-align: center;">$${product.price}</p>
		</div>
		<p style="margin-bottom: 0; margin-top: 0;">
			<a
				style="background: rgb(5, 135, 190) url('images/magnifier.png') no-repeat 6px 50%; padding-left: 1.5em;"
				href="#">Details</a> <a
				style="background: rgb(5, 135, 190) url('images/cart.png') no-repeat 6px 50%; padding-left: 1.5em;"
				href="#">Add to cart</a>
		</p>
	</div>
</c:forEach>