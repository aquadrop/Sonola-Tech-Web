/*
* CakePHP Twitter Bootstrappifier
*
* Converts cakephp elements into Twitter Bootstrap style.
*
* Works with Bootstrap v2+ and CakePHP v2+
*
* Written by: Jeff Lee
*/

function form_horizontal_boostrap() {
	var textInputs = ['text', 'password', 'datetime', 'datetime-local', 'month', 'time', 'week', 'number', 'email', 'url', 'tel', 'color'];

	for (i in textInputs) {
		jQuery('.form-horizontal div[class*="input ' + textInputs[i] + '"]').addClass('control-group');
		jQuery('.form-horizontal div[class*="input ' + textInputs[i] + '"] label').addClass('control-label');
		jQuery('.form-horizontal div[class*="input ' + textInputs[i] + '"] > label ~ input').wrap('<div class="controls" />');
	}

	// Convert Textarea Inputs
	jQuery('.form-horizontal div[class*="input textarea"]').addClass('control-group');
	jQuery('.form-horizontal div[class*="input textarea"] label').addClass('control-label');
	jQuery('.form-horizontal div[class*="input textarea"] > label ~ textarea').wrap('<div class="controls" />');

	// Convert Submit Forms
	jQuery('.form-horizontal input[type="submit"][class!="btn btn-primary"]').wrap('<div class="form-actions" />');
	jQuery('.form-horizontal input[type="submit"]').addClass('btn btn-primary btn-large');

	// Convert Select Inputs
	jQuery('.form-horizontal div[class*="input select"]:not(:has(div.checkbox))').addClass('control-group');
	jQuery('.form-horizontal div[class*="input select"]:not(:has(div.checkbox)) label').addClass('control-label');
	jQuery('.form-horizontal div[class*="input select"]:not(:has(div.checkbox)) > label ~ select').wrap('<div class="controls" />');

	// Convert Date Inputs
	jQuery('.form-horizontal div[class*="input date"]').addClass('control-group');
	jQuery('.form-horizontal div[class*="input date"] label').addClass('control-label');
	jQuery('.form-horizontal div[class*="input date"]').wrapInner('<div class="controls" />');
	jQuery('.form-horizontal div[class*="input date"] div.controls label').each(function(){
		jQuery(this).insertBefore(jQuery(this).parent("div.controls"));
	});
	jQuery('.form-horizontal div[class*="input date"] div.controls select:nth-child(1)').css("width", "80px");
	jQuery('.form-horizontal div[class*="input date"] div.controls select:nth-child(2)').css("width", "50px");
	jQuery('.form-horizontal div[class*="input date"] div.controls select:nth-child(3)').css("width", "80px");

	// Convert Checkbox Inputs
	jQuery('.form-horizontal div[class*="input select"]:has(div.checkbox)').addClass("control-group");
	jQuery('.form-horizontal div[class*="input select"]:has(div.checkbox) label').addClass("control-label");
	jQuery('.form-horizontal div[class*="input select"]:has(div.checkbox)').append('<div class="btn-group controls" data-toggle="buttons-checkbox" />');
	jQuery('.form-horizontal div[class*="input select"]:has(div.checkbox) div.checkbox').each(function(){
		var label = jQuery(this).children('label').first();
		var input = jQuery(this).children('input').first();
		var btn_group = jQuery(this).siblings("div.btn-group").first();
		var btn = jQuery('<button class="btn" />');

		btn.html(label.html());
		btn.attr('value', input.val());
		btn.attr('id', 'btn' + input.attr('id'));
		btn_group.append(btn);
		btn.click(function(e){
			e.preventDefault();
			jQuery('input[name="' + input.attr("name") + '"][value="' + input.val() + '"]').click();
		});
		jQuery(this).hide();
	});

	// Convert Radio Inputs
	jQuery('.form-horizontal div[class*="input radio"]').addClass('btn-group controls').attr('data-toggle', 'buttons-radio');
	jQuery('.form-horizontal div[class*="input radio"] fieldset input[type=radio]').each(function(){
		var btn = jQuery("<button class='btn' />");
		var inputName = jQuery(this).attr("name");
		if (jQuery(this).is(":checked")) {
			btn.addClass("active");
		}
		btn.html(jQuery(this).next("label").html());
		btn.attr("value", jQuery(this).val());
		btn.attr('id', 'btn' + jQuery(this).attr('id'));
		btn.insertBefore(jQuery(this).parent("fieldset"));
		btn.click(function(e){
			e.preventDefault();
			jQuery('input[name="' + inputName + '"][value="' + jQuery(this).val() + '"]').click();
		});
	});
	jQuery('.form-horizontal div[class*="input radio"]').wrap('<div class="control-group" />');
	jQuery('.form-horizontal div[class*="input radio"] fieldset').each(function(){
		jQuery('<label class="control-label" />')
			.html(jQuery('.form-horizontal div[class*="input radio"] fieldset legend').html())
			.insertBefore(jQuery(this).parent("div.btn-group"));
		jQuery(this).insertBefore(jQuery(this).parent("div.btn-group")).hide();
	});
}

function form_inline_boostrap() {
	jQuery('.form-inline').addClass("well");

	var spacing = {'margin' : '0 2px'};

	jQuery('.form-inline div.input').each(function(){
		if (jQuery(this).hasClass('select')) {
			var label = jQuery(this).children('label').first();
			var input = jQuery(this).children('select').first();

			label.appendTo(jQuery(this).parent('form')).css(spacing);
			input.appendTo(jQuery(this).parent('form')).css(spacing);
		}
	});

	jQuery('.form-inline div.input').each(function(){
		if (jQuery(this).hasClass('text') || jQuery(this).hasClass('password') || jQuery(this).hasClass('email') || jQuery(this).hasClass('number')) {
			var label = jQuery(this).children('label').first();
			var input = jQuery(this).children('input').first();

			label.appendTo(jQuery(this).parent('form'));
			input.appendTo(jQuery(this).parent('form'));
		}
	});

	jQuery('.form-inline div[class*="submit"]').each(function(){
		var btn = jQuery(this).children('input').first();
		btn.addClass('btn').css(spacing);
		btn.appendTo(jQuery(this).parent('form'));
	});

	// Convert Date Inputs
	// Convert Checkbox Inputs
	// Convert Radio Inputs
}

function form_prepend_append_bootstrap() {
	jQuery('input[type=text], input[type=number]').each(function(){
		if (jQuery(this).attr('prepend') != null) {
			jQuery(this).wrap('<div class="input-prepend" />');
			jQuery(this).before('<span class="add-on">' + jQuery(this).attr('prepend') + '</span>');
		}
		if (jQuery(this).attr('append') != null) {
			jQuery(this).wrap('<div class="input-append" />');
			jQuery(this).after('<span class="add-on">' + jQuery(this).attr('append') + '</span>');
		}
	});
}

function pagination_boostrap() {
	jQuery('.pagination').append("<ul class='pagination-centered'/>");
	jQuery('.pagination span').each(function(e, data){
		if (jQuery(this).find('a').length == 0) {
			jQuery('.pagination ul').append(jQuery("<li/>").append(jQuery(this).html()).addClass(jQuery(this).attr('class')));
		} else {
			jQuery('.pagination ul').append(jQuery("<li/>").append(jQuery(this).find('a')));
		}
		jQuery(this).hide();
	});

	jQuery('.pagination ul li.disabled').wrapInner(jQuery('<a href="#" />').click(function(e){e.preventDefault();}));
	jQuery('.pagination ul li.current').addClass('active').wrapInner(jQuery('<a href="#" />').click(function(e){e.preventDefault();}));
}

function flash_bootstrap() {
	// Success Flash
	jQuery('.flash-success').addClass('alert alert-success');
	jQuery('<a class="close" data-dismiss="alert">&times;</a>').prependTo(jQuery('.flash-success'));
	jQuery('<strong>Success!&nbsp;&nbsp;</strong>').prependTo(jQuery('.flash-success'));

	// Info Flash
	jQuery('.flash-info').addClass('alert alert-info');
	jQuery('<a class="close" data-dismiss="alert">&times;</a>').prependTo(jQuery('.flash-info'));
	jQuery('<strong>Heads Up!&nbsp;&nbsp;</strong>').prependTo(jQuery('.flash-info'));

	// Warning Flash
	jQuery('.flash-warning').addClass('alert alert-warning');
	jQuery('<a class="close" data-dismiss="alert">&times;</a>').prependTo(jQuery('.flash-warning'));
	jQuery('<strong>Warning!&nbsp;&nbsp;</strong>').prependTo(jQuery('.flash-warning'));

	// Error Flash
	jQuery('.flash-error').addClass('alert alert-error');
	jQuery('<a class="close" data-dismiss="alert">&times;</a>').prependTo(jQuery('.flash-error'));
	jQuery('<strong>Error!&nbsp;&nbsp;</strong>').prependTo(jQuery('.flash-error'));

	// If no flash class set, such as Auth msg, default to success
	jQuery('.message[id!=authMessage]').each(function(){
		if (!jQuery(this).hasClass("flash-success") && !jQuery(this).hasClass("flash-warning") && !jQuery(this).hasClass("flash-error")) {
			jQuery(this).addClass('alert alert-success');
			jQuery('<strong>Success!&nbsp;&nbsp;</strong>').prependTo(jQuery(this));
		}
	});

	// Auth Error
	jQuery('#authMessage').addClass('alert alert-error');
	jQuery('<a class="close" data-dismiss="alert">&times;</a>').prependTo(jQuery('#authMessage'));
	jQuery('<strong>Error!&nbsp;&nbsp;</strong>').prependTo(jQuery('#authMessage'));

	// Form Error Alert
	jQuery('.form-horizontal .error .error-message').each(function(e, data){
		jQuery(data).parent().find('.controls').append('<span class="help-inline">' + jQuery(this).text() + '</span>');
		jQuery(data).remove();
	});
}

function icon_bootstrap() {
	jQuery('*').each(function(){
		if (jQuery(this).attr('icon') != null) {
			// For Navi links
			var isActive = "";
			if (jQuery(this).parent('li').hasClass('active') && !jQuery(this).closest('ul').hasClass('nav-tabs')) {
				isActive = "icon-white";
			}

			jQuery(this).prepend('<i class="icon-' + jQuery(this).attr('icon') + " " + isActive + '"></i>' + (jQuery(this).html() == '' ? '' : ' '));
		}
	})
}

jQuery(document).ready(function(){
	jQuery('table').addClass('table table-striped');
	jQuery('form').each(function(){
		if (jQuery(this).hasClass("form-inline") == false) {
			jQuery(this).addClass('form-horizontal');
		}
	});

	form_horizontal_boostrap();
	form_inline_boostrap();
	form_prepend_append_bootstrap();

	pagination_boostrap();
	flash_bootstrap();
	icon_bootstrap();
});