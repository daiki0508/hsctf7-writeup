#dis 209pt(129solves)

```
 lost my source code and all I can find is this disassembly.
```

与えられたファイルには逆アセンブリ化されたコードがあった。<br>
更にdisという問題文の名前から恐らくpythonの『disモジュール』のことという想像もすることが出来ます。

```
Disassembly of a:
  3           0 LOAD_CONST               1 (0)
              2 BUILD_LIST               1
              4 LOAD_GLOBAL              0 (len)
              6 LOAD_FAST                0 (s)
              8 CALL_FUNCTION            1
             10 BINARY_MULTIPLY
             12 STORE_FAST               1 (o)

  4          14 LOAD_GLOBAL              1 (enumerate)
             16 LOAD_FAST                0 (s)
             18 CALL_FUNCTION            1
             20 GET_ITER
        >>   22 FOR_ITER                24 (to 48)
             24 UNPACK_SEQUENCE          2
             26 STORE_FAST               2 (i)
             28 STORE_FAST               3 (c)

  5          30 LOAD_FAST                3 (c)
             32 LOAD_CONST               2 (2)
             34 BINARY_MULTIPLY
             36 LOAD_CONST               3 (60)
             38 BINARY_SUBTRACT
             40 LOAD_FAST                1 (o)
             42 LOAD_FAST                2 (i)
             44 STORE_SUBSCR
             46 JUMP_ABSOLUTE           22

  6     >>   48 LOAD_FAST                1 (o)
             50 RETURN_VALUE

Disassembly of b:
  9           0 LOAD_GLOBAL              0 (zip)
              2 LOAD_FAST                0 (s)
              4 LOAD_FAST                1 (t)
              6 CALL_FUNCTION            2
              8 GET_ITER
        >>   10 FOR_ITER                22 (to 34)
             12 UNPACK_SEQUENCE          2
             14 STORE_FAST               2 (x)
             16 STORE_FAST               3 (y)

 10          18 LOAD_FAST                2 (x)
             20 LOAD_FAST                3 (y)
             22 BINARY_ADD
             24 LOAD_CONST               1 (50)
             26 BINARY_SUBTRACT
             28 YIELD_VALUE
             30 POP_TOP
             32 JUMP_ABSOLUTE           10
        >>   34 LOAD_CONST               0 (None)
             36 RETURN_VALUE

Disassembly of c:
 13           0 LOAD_CONST               1 (<code object <listcomp> at 0x7ff31a16f0e0, file "vuln.py", line 13>)
              2 LOAD_CONST               2 ('c.<locals>.<listcomp>')
              4 MAKE_FUNCTION            0
              6 LOAD_FAST                0 (s)
              8 GET_ITER
             10 CALL_FUNCTION            1
             12 RETURN_VALUE

Disassembly of <code object <listcomp> at 0x7ff31a16f0e0, file "vuln.py", line 13>:
 13           0 BUILD_LIST               0
              2 LOAD_FAST                0 (.0)
        >>    4 FOR_ITER                12 (to 18)
              6 STORE_FAST               1 (c)
              8 LOAD_FAST                1 (c)
             10 LOAD_CONST               0 (5)
             12 BINARY_ADD
             14 LIST_APPEND              2
             16 JUMP_ABSOLUTE            4
        >>   18 RETURN_VALUE

Disassembly of e:
 16           0 LOAD_CONST               1 (<code object <listcomp> at 0x7ff31a16f240, file "vuln.py", line 16>)
              2 LOAD_CONST               2 ('e.<locals>.<listcomp>')
              4 MAKE_FUNCTION            0
              6 LOAD_FAST                0 (s)
              8 GET_ITER
             10 CALL_FUNCTION            1
             12 STORE_FAST               0 (s)

 17          14 LOAD_CONST               3 (<code object <listcomp> at 0x7ff31a16f2f0, file "vuln.py", line 17>)
             16 LOAD_CONST               2 ('e.<locals>.<listcomp>')
             18 MAKE_FUNCTION            0
             20 LOAD_GLOBAL              0 (b)
             22 LOAD_GLOBAL              1 (a)
             24 LOAD_FAST                0 (s)
             26 CALL_FUNCTION            1
             28 LOAD_GLOBAL              2 (c)
             30 LOAD_FAST                0 (s)
             32 CALL_FUNCTION            1
             34 CALL_FUNCTION            2
             36 GET_ITER
             38 CALL_FUNCTION            1
             40 STORE_FAST               1 (o)

 18          42 LOAD_GLOBAL              3 (bytes)
             44 LOAD_FAST                1 (o)
             46 CALL_FUNCTION            1
             48 RETURN_VALUE

Disassembly of <code object <listcomp> at 0x7ff31a16f240, file "vuln.py", line 16>:
 16           0 BUILD_LIST               0
              2 LOAD_FAST                0 (.0)
        >>    4 FOR_ITER                12 (to 18)
              6 STORE_FAST               1 (c)
              8 LOAD_GLOBAL              0 (ord)
             10 LOAD_FAST                1 (c)
             12 CALL_FUNCTION            1
             14 LIST_APPEND              2
             16 JUMP_ABSOLUTE            4
        >>   18 RETURN_VALUE

Disassembly of <code object <listcomp> at 0x7ff31a16f2f0, file "vuln.py", line 17>:
 17           0 BUILD_LIST               0
              2 LOAD_FAST                0 (.0)
        >>    4 FOR_ITER                16 (to 22)
              6 STORE_FAST               1 (c)
              8 LOAD_FAST                1 (c)
             10 LOAD_CONST               0 (5)
             12 BINARY_XOR
             14 LOAD_CONST               1 (30)
             16 BINARY_SUBTRACT
             18 LIST_APPEND              2
             20 JUMP_ABSOLUTE            4
        >>   22 RETURN_VALUE

Disassembly of main:
 21           0 LOAD_GLOBAL              0 (input)
              2 LOAD_CONST               1 ('Guess?')
              4 CALL_FUNCTION            1
              6 STORE_FAST               0 (s)

 22           8 LOAD_CONST               2 (b'\xae\xc0\xa1\xab\xef\x15\xd8\xca\x18\xc6\xab\x17\x93\xa8\x11\xd7\x18\x15\xd7\x17\xbd\x9a\xc0\xe9\x93\x11\xa7\x04\xa1\x1c\x1c\xed')
             10 STORE_FAST               1 (o)

 23          12 LOAD_GLOBAL              1 (e)
             14 LOAD_FAST                0 (s)
             16 CALL_FUNCTION            1
             18 LOAD_FAST                1 (o)
             20 COMPARE_OP               2 (==)
             22 POP_JUMP_IF_FALSE       34

 24          24 LOAD_GLOBAL              2 (print)
             26 LOAD_CONST               3 ('Correct!')
             28 CALL_FUNCTION            1
             30 POP_TOP
             32 JUMP_FORWARD             8 (to 42)

 26     >>   34 LOAD_GLOBAL              2 (print)
             36 LOAD_CONST               4 ('Wrong...')
             38 CALL_FUNCTION            1
             40 POP_TOP
        >>   42 LOAD_CONST               0 (None)
             44 RETURN_VALUE
```

上の内容からmainの8行目の16進数を復号化すればflagが得られることを想像できる。<br>
よって記述するpythonコードは以下のようになる。

```python
''.join([chr((((x+30)^5)+105)//3) for x in b'\xae\xc0\xa1\xab\xef\x15\xd8\xca\x18\xc6\xab\x17\x93\xa8\x11\xd7\x18\x15\xd7\x17\xbd\x9a\xc0\xe9\x93\x11\xa7\x04\xa1\x1c\x1c\xed'])
```
