$(document).ready(function () {
    //pobranie id zestawu ze ścieżki URL
    var setId = window.location.pathname.split('/').pop();

    //deklaracja zmiennych
    var set; //zestaw pobrany z serwera
    var counter; //licznik fiszek
    var side; //true = lewa, false = prawa
    var memorized; //licznik zapamiętanych fiszek
    var forgotten; //licznik zapomnianych fiszek

    //dodanie akcji do kliknięć
    //kliknięcie w fiszkę sprawa, że zmieniana jest strona
    $('#leftSide,#rightSide').click(changeSide);
    //kliknięcie w symbol 'check' inkrementuje licznik zapamiętanych i zmienia fiszkę na kolejną
    $('#memorized').click(function () {
        memorized++;
        changeFlashcard();
    });
    //kliknięcie w symbol 'reject' inkrementuje licznik zapomnianych i zmienia fiszkę na kolejną
    $('#forgotten').click(function () {
        forgotten++;
        changeFlashcard();
    });
    //kliknięcie w przycisk reset resetuje zestaw
    $('#reset').click(start);

    //pobranie zestawu z serwera i rozpoczęcie wyświetlania
    $.ajax({
        url: "/set/test/" + setId
    }).done(function (data) {
        console.log(data);
        set = data;
        start();
    });

    //funkcja inicjująca
    function start() {
        initVariables();
        initInterface();
        updateSide();
        updateFlashcard();
        updateProgress();
    }

    //inicjowanie zmiennych wartościami początkowymi
    function initVariables() {
        counter = 1;
        side = true;
        memorized = 0;
        forgotten = 0;
    }

    //inicjowanie interfejsu
    function initInterface() {
        $('#title').text(set.title);
        $('#languages').text(set.languages);
        $('#test').show();
        $('#summary').hide();
    }

    //odwrócenie fiszki
    function changeSide() {
        side = !side;
        updateSide()
    }

    //odwrócenie fiszki na lewą stronę
    function resetSide() {
        side = true;
        updateSide()
    }

    //odwrócenie fiszki na stronę wskazywaną przez zmienną side
    //true = lewa, false = prawa
    function updateSide() {
        if (side) {
            $('#rightSide').hide();
            $('#leftSide').show();
            $('#rightSideLabel').hide();
            $('#leftSideLabel').show();
        } else {
            $('#leftSide').hide();
            $('#rightSide').show();
            $('#leftSideLabel').hide();
            $('#rightSideLabel').show();
        }
    }

    //zmiana fiszki na kolejną
    function updateFlashcard() {
        var flashcard = set.flashcards[counter - 1];
        $('#leftSide').text(flashcard.leftSide);
        $('#rightSide').text(flashcard.rightSide);
    }

    //aktualizacja postępu
    function updateProgress() {
        $('#progress').text(counter + ' : ' + set.flashcards.length);
    }

    //wyświetlenie podsumowania
    function showSummary() {
        if (memorized / set.flashcards.length > 0.4) {
            $('#congratulations').show();
            $('#reprimand').hide();
        } else {
            $('#congratulations').hide();
            $('#reprimand').show();
        }
        $('#sumMemorized').text(memorized);
        $('#sumForgotten').text(forgotten);
        $('#allFlashcards').text(set.flashcards.length);
        $('#test').hide();
        $('#summary').show();
    }

    //zmiana fiszki na kolejną lub wyświetlenie podsumowania po kliknięciu 'check' lub 'reject'
    function changeFlashcard() {
        if (counter < set.flashcards.length) {
            counter++;
            resetSide();
            updateFlashcard();
            updateProgress();
        } else {
            showSummary();
        }
    }
})