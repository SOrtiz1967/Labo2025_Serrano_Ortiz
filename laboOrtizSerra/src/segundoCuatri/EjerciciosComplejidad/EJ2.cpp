/*Calcular el tiempo de ejecución de peor caso (en notación O grande) de los
siguientes programas con respecto al tamaño de los secuencias de entrada.
Recordar que tanto la lectura como la escritura de un elemento en un vector
tiene tiempo de ejecución perteneciente a O(1)*/

void f1 (vector &vec) {
i = vec.size() / 2;
while ( i >= 0 ){
vec [ vec.size () / 2 - i ] = i;
vec [ vec.size () / 2 + i ] = i;
i - -;
}
}
void f2 (vector &vec) {
i = 0;
while ( i < 10000){
vec [ vec.size() / 2 - i ] = i ;
vec [ vec.size() / 2 + i ] = i ;
i ++;
}
}
int f3 (vector &v1, int e) {
int i = 0;
while ( v1[ i ] != e ){
i ++;
}
return i;
}
void f4 (vector &vec) {
int rec = 0;
int max_iter = 1000;
if (max_iter > vec.size()) {
max_iter = vec . size ();
}
for (int i =0; i < max_iter; i++) {
for(int j =0; j < max_iter ; j++) {
res += vec [ i ] * vec [ j ];
}
}
}
void f5 (vector &v1 , vector &v2) {
vector res ();
for (int i =0; i < v1 . size (); i ++){
res.push_back (v1[ i ]); // O(1)
}
for (int i =0; i < v2 . size (); i ++){
res.push_back (v2[ i ]); // O(1)
}
return res ;
}
3. int mesetaMasLarga (vector &v) {
int i = 0;
int maxMeseta =