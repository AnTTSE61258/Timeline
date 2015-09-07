/**
 * 
 */
var FAVORITE_VARIABLE = "favorite";
$(document).ready(function() {
	addItemToFavorite('a', 'b');
	getAllFavorites();
	addOneItemsToView('a','b');
	addOneItemsToView('a','b');
});

function addItemToFavorite(seourl, title) {
	var favoriteItem = FAVORITE_VARIABLE + '.' + seourl;
	localStorage[favoriteItem] = title;
}

function addOneItemsToView(seourl ,title){
	jQuery("#menu-side-menu").append('<li class="sub-item menu-item menu-item-type-custom menu-item-object-custom"><a href="#inline">'+title+'</a></li>')
	
}

function getAllFavorites() {
	var favorites = [];
	for ( var key in localStorage) {
		favorites[favorites.length] = key;
		if (key.substring(0, FAVORITE_VARIABLE.length).localeCompare(FAVORITE_VARIABLE)===0)
			//DO SOMETHINGS HEREs
			alert(key.substring(FAVORITE_VARIABLE.length+1, key.length));
	}
}