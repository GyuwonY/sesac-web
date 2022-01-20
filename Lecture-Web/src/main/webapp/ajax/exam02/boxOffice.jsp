<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#searchResult {
		width: 70%;
		height: 1000px;
		border: 1px solid red;
	}
	
	.detail02 {
		height: 100px;
		border: 1px solid blue;
	}
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#searchBtn').click(function() {
			//검색일 추출
			let searchDate = $('#searchDate').val()
			searchDate = searchDate.split('-').join('')
			$.ajax({
				url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
				type: 'get',
				data: {
					key: 'eaacd659c16ba4cfe7a355eda0ecf5a8',
					targetDt: searchDate,
					itemPerPage: '5'
				}, success: callback,
				error: function(){
					alert('실패')
				}
			})
		})
		$(document).on("click", ".detail",function() {
			let cd = $(this).attr('id')
			$('button#'+cd).after('<div class="detail02" id='+cd+'>상세보기</div>')
			$.ajax({
				url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json',
				type: 'get',
				data: {
					key: 'eaacd659c16ba4cfe7a355eda0ecf5a8',
					movieCd: cd
				}, success : function(casting) {
					let directors = casting.movieInfoResult.movieInfo.directors
					let genres = casting.movieInfoResult.movieInfo.genres
					console.log(genres)
					let actors = casting.movieInfoResult.movieInfo.actors
					console.log(actors)
					for(let director of directors) {
						let dName= director.peopleNm
						console.log(dName)
						$('div#'+cd).append('감독명 : ' + dName)
					}
					for(let genre of genres){
						$('div#'+cd).append('장르 : ' + genre.genreNm)
					}
					$('div#'+cd).append('배우정보')
					for(let actor of actors){
						$('div#'+cd).append(actor.peopleNm +' ('+ actor.cast +')')
					}
				},error: function() {
					alert('실패')
				}
			})
		})
	})

	function callback(result) {
		$('#searchResult').empty() // 전에 했던 검색 결과 지우기
		let list = result.boxOfficeResult.dailyBoxOfficeList
		for(let movie of list){
			// 순위
			let rank= movie.rank
			// 영화제목
			let name= movie.movieNm 
			// 관객수
			let audiCnt= movie.audiCnt
			let cd= movie.movieCd
			
			$('#searchResult').append('<h4>' + rank + '위</h4>')
			$('#searchResult').append('<strong>'+ name +'<strong>(' + audiCnt + '명)<br>')
			$('#searchResult').append('<button class="detail" id="'+cd+'">상세보기</button>')
			$('#searchResult').append('<hr>')
		}
	}
</script>
</head>
<body>
	<h2>일별 박스오피스 조회서비스</h2>
	검색일 : <input type="date" id="searchDate">
	<button id="searchBtn">조회</button>
	<h3>검색결과</h3>
	<div id="searchResult"></div>
</body>
</html>