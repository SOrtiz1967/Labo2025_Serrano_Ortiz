int ultimo1 (vector v) {
 return v[ v.size() - 1 ];//4 o(1)
}//o(1)//4
int ultimo2 (vector v) {
int i = v.size();//3 o(1)
return v[ i - 1 ];//3 o(1)
}//o(1)//6
int ultimo3 (vector v) {
int i = 0;//2 o(1)
while ( i < v.size() ) {//3*n o(n)
i ++;//1*n o(1)
}//o(n) 4*n
return v[ i - 1 ];//o(1)
}//o(n)

//18+4*n=total
//22 operaciones elementales