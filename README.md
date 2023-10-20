# Prop
# Per clonar el projecte: 
git clone https://github.com/oriolramospuig/Prop.git

# Per carregar el contingut 
git pull / git pull origin

# Per crear una branca
git checkout -b "nom"

# Per moure's entre branques
git checkout "nom_on_anar"

# Per pujar canvis a la branca
git add .
git commit -m "missatge"
git push / git push nom_branca

# Si ens diu que s'ha de fer merge
Si volem descartar els nostres canvis: Des del visual fem Rollback i tirem enrere els canvis
Si volem ajuntar-los des del visual adaptem codi.
Si cada cop abans de fer canvis fem un git pull origin no haurem de fer merge mai, perquè no tindrem canvis externs al codi, sempre estarà actualitzat
