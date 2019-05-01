<template>
  <el-upload
    class="upload-demo"
    drag
    id="myupload"
    action="http://localhost:8686/hrjob/resume"
    multiple>
    <i class="el-icon-upload"></i>
    <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
  </el-upload>
</template>

<script>
export default {
  name: 'HelloWorld',
  mounted() {
    var elementsByName = window.document.getElementsByName("file");
    for (let i = 0; i < elementsByName.length; i++) {
      if (i === 0) {
        var fileinput=elementsByName[i]
        fileinput.setAttribute("webkitdirectory","")
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
