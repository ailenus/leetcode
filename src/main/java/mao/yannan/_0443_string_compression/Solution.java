package mao.yannan._0443_string_compression;

class Solution {

    public int compress(char[] chars) {
        var read = 0;
        var write = 0;
        while (read < chars.length) {
            var letter = chars[read];
            var start = read;
            while (read < chars.length && chars[read] == letter) {
                read++;
            }
            var count = read - start;
            chars[write] = letter;
            write++;
            if (count > 1) {
                for (var d : String.valueOf(count).toCharArray()) {
                    chars[write] = d;
                    write++;
                }
            }
        }
        return write;
    }

}
