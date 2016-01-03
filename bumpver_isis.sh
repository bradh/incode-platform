VERSION=$1

if [ ! "$VERSION" ]; then
    echo "usage: $(basename $0) [version]"
    exit 1
fi

# edit parent pom.xml
echo "editing parent pom.xml"
cat pom.xml | sed "s/<isis.version>.*</<isis.version>$VERSION</" > pom.xml.$$.sed
mv pom.xml.$$.sed pom.xml

# edit glue's pom.xml
echo "editing glue's pom.xml"
pushd glue >/dev/null
cat pom.xml | sed "s/<isis.version>.*</<isis.version>$VERSION</" > pom.xml.$$.sed
mv pom.xml.$$.sed pom.xml
popd >/dev/null

echo "Committing changes"
git commit -am "bumping isis.version to $VERSION"

