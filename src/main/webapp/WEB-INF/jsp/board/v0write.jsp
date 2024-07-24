<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="mx-auto max-w-2xl space-y-6 py-12">
	  <div class="space-y-2">
	    <h1 class="text-3xl font-bold">새 게시물 작성</h1>
	    <p class="text-gray-500 dark:text-gray-400">아래 양식을 작성하여 새 블로그 게시물을 만드세요.</p>
	  </div>
	  <form class="space-y-4">
	    <div class="grid grid-cols-2 gap-4">
	      <div class="space-y-2">
	        <label
	          class="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
	          for="author"
	        >
	          작성자
	        </label>
	        <input
	          class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
	          id="author"
	          placeholder="이름을 입력하세요"
	        />
	      </div>
	      <div class="space-y-2">
	        <label
	          class="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
	          for="title"
	        >
	          제목
	        </label>
	        <input
	          class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
	          id="title"
	          placeholder="제목을 입력하세요"
	        />
	      </div>
	    </div>
	    <div class="space-y-2">
	      <label
	        class="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
	        for="content"
	      >
	        내용
	      </label>
	      <textarea
	        class="flex w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 min-h-[300px]"
	        id="content"
	        placeholder="게시물 내용을 작성하세요..."
	      ></textarea>
	    </div>
	    <button
	      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-primary-foreground hover:bg-primary/90 h-10 px-4 py-2 w-full"
	      type="submit"
	    >
	      저장 및 게시
	    </button>
	  </form>
	</div>

</body>
</html>


<!--
// v0 by Vercel.
// https://v0.dev/t/pPU9WJRzHmc
-->
