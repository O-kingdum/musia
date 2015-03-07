$(function() {
	var now_year = new Date().getFullYear();

	for (var i = now_year - 100; i <= now_year; i++) {
		$(".year").append("<option value='" + i + "'>" + i + "</option>");
	}

	for (var i = 1; i <= 12; i++) {
		$(".month").append("<option value='" + i + "'>" + i + "</option>");
	}

	// 月日に応じて日数を決める
	$(".date").change(function() {

		var year = $("[name=year]   option:selected").val();
		var month = $("[name=month]  option:selected").val();
		var day = new Date(year, month, 0).getDate();

		$(".day").empty();
		$(".day").append("<option value='0'>---</option>");

		for (var i = 1; i <= day; i++) {
			$(".day").append("<option value='" + i + "'>" + i + "</option>");
		}

	});

});
