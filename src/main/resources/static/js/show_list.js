// 셀렉트 필터(기술스택)
function handleStackFilter(event) {
    let filter = event.target.value;

    console.log(typeof filter);

    if (filter == 'all')
        window.location.reload();
    else {
        $.ajax({
            url: '/api/project/skill/' + filter,
            type: "get",
            dataType: "json"
        }).done(res => {
            console.log("성공", res);
            $('#showList').empty();
            if (res.data.length === 0) {
                $('.show-top').append('<p class="search-null">해당 조건에 맞는 프로젝트가 존재하지 않습니다. 다시 검색해주세요.</p>');
            } else {
                res.data.forEach(project => {
                    let skillImages = '';
                    let count = 0;
                    project.skills.forEach(skill => {
                        // 기술 스택이 6개가 넘어가지 않도록 제한
                        if (count < 6) {
                            let imgSrc;
                            switch (skill) {
                                case 'AWS':
                                    imgSrc = '/img/aws.svg';
                                    break;
                                case 'Docker':
                                    imgSrc = '/img/docker.svg';
                                    break;
                                case 'Figma':
                                    imgSrc = '/img/figma.svg';
                                    break;
                                case 'Flutter':
                                    imgSrc = '/img/flutter.svg';
                                    break;
                                case 'Git':
                                    imgSrc = '/img/git.svg';
                                    break;
                                case 'Java':
                                    imgSrc = '/img/java.svg';
                                    break;
                                case 'JavaScript':
                                    imgSrc = '/img/javascript.svg';
                                    break;
                                case 'Jest':
                                    imgSrc = '/img/jest.svg';
                                    break;
                                case 'Kotlin':
                                    imgSrc = '/img/kotlin.svg';
                                    break;
                                case 'MongoDb':
                                    imgSrc = '/img/mongodb.svg';
                                    break;
                                case 'MySQL':
                                    imgSrc = '/img/mysql.svg';
                                    break;
                                case 'Nodejs':
                                    imgSrc = '/img/nodejs.svg';
                                    break;
                                case 'php':
                                    imgSrc = '/img/php.svg';
                                    break;
                                case 'Python':
                                    imgSrc = '/img/python.svg';
                                    break;
                                case 'React':
                                    imgSrc = '/img/react.svg';
                                    break;
                                case 'ReactNative':
                                    imgSrc = '/img/reactnative.svg';
                                    break;
                                case 'Spring':
                                    imgSrc = '/img/spring.svg';
                                    break;
                                case 'Svelte':
                                    imgSrc = '/img/svelte.svg';
                                    break;
                                case 'TypeScript':
                                    imgSrc = '/img/typescript.svg';
                                    break;
                                case 'Vue':
                                    imgSrc = '/img/vue.svg';
                                    break;
                                default:
                                    imgSrc = ''; // 이미지가 없는 경우
                            }
                            skillImages += imgSrc ? `<img src="${imgSrc}" alt="${skill}"/>` : `<span>${skill}</span>`;
                            count++;
                        }
                    });

                    $('#showList').append(`
                        <a href="/project/show/${project.id}" class="show-box">
                            <div class="img-wrap">
                                <img src="/upload/${project.imageUrl}" alt="프로필 이미지"/>
                            </div>
                            <div class="box-text">
                                <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
                                <h2>${project.projectName}</h2>
                                <ul class="skill">
                                    <li>${skillImages}</li>
                                </ul>
                                <div class="lists-bot">
                                    <p>${project.teamName}</p>
                                    <ul class="count">
                                        <li><i class="fa-solid fa-eye"></i>${project.views}회</li>
                                        <li><i class="fa-regular fa-thumbs-up"></i>${project.likes}개</li>
                                    </ul>
                                </div>
                            </div>
                        </a>
                    `);
                });
            }
        }).fail(error => {
            console.log("실패", error);
        });
    }
}

// 셀렉트 필터(최신, 오래된, 북마크순)
function handleSelectFilter(event) {
    let selectedCondition = event.target.value;

    let apiUrl = '/api/show/select/';
    if (selectedCondition === 'new') {
        apiUrl += 'new';
    } else if (selectedCondition === 'old') {
        apiUrl += 'old';
    } else if (selectedCondition === 'save') {
        apiUrl += 'save';
    } else {
        return;
    }
    console.log(selectedCondition);
    console.log(apiUrl);

    $.ajax({
        url: apiUrl,
        type: "get",
        dataType: "json"
    }).done(res => {
        console.log("성공", res);

        $('#showList').empty();
        if (res.data.length === 0) {
            $('#showList').append('<p class="search-null">프로젝트가 존재하지 않습니다. 다른 조건으로 검색해주세요.</p>');
        } else {
            res.data.forEach(project => {
                let skillImages = '';
                let count = 0;
                project.skills.forEach(skill => {
                    if (count < 6) {
                        let imgSrc;
                        switch (skill) {
                            case 'AWS':
                                imgSrc = '/img/aws.svg';
                                break;
                            case 'Docker':
                                imgSrc = '/img/docker.svg';
                                break;
                            case 'Figma':
                                imgSrc = '/img/figma.svg';
                                break;
                            case 'Flutter':
                                imgSrc = '/img/flutter.svg';
                                break;
                            case 'Git':
                                imgSrc = '/img/git.svg';
                                break;
                            case 'Java':
                                imgSrc = '/img/java.svg';
                                break;
                            case 'JavaScript':
                                imgSrc = '/img/javascript.svg';
                                break;
                            case 'Jest':
                                imgSrc = '/img/jest.svg';
                                break;
                            case 'Kotlin':
                                imgSrc = '/img/kotlin.svg';
                                break;
                            case 'MongoDb':
                                imgSrc = '/img/mongodb.svg';
                                break;
                            case 'MySQL':
                                imgSrc = '/img/mysql.svg';
                                break;
                            case 'Nodejs':
                                imgSrc = '/img/nodejs.svg';
                                break;
                            case 'php':
                                imgSrc = '/img/php.svg';
                                break;
                            case 'Python':
                                imgSrc = '/img/python.svg';
                                break;
                            case 'React':
                                imgSrc = '/img/react.svg';
                                break;
                            case 'ReactNative':
                                imgSrc = '/img/reactnative.svg';
                                break;
                            case 'Spring':
                                imgSrc = '/img/spring.svg';
                                break;
                            case 'Svelte':
                                imgSrc = '/img/svelte.svg';
                                break;
                            case 'TypeScript':
                                imgSrc = '/img/typescript.svg';
                                break;
                            case 'Vue':
                                imgSrc = '/img/vue.svg';
                                break;
                            default:
                                imgSrc = ''; // 이미지가 없는 경우
                        }
                        skillImages += imgSrc ? `<img src="${imgSrc}" alt="${skill}"/>` : `<span>${skill}</span>`;
                        count++;
                    }
                });

                $('#showList').append(`
                    <a href="/project/show/${project.id}" class="show-box">
                        <div class="img-wrap">
                            <img src="/upload/${project.imageUrl}" alt="프로필 이미지"/>
                        </div>
                        <div class="box-text">
                            <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
                            <h2>${project.projectName}</h2>
                            <ul class="skill">
                                <li>${skillImages}</li>
                            </ul>
                            <div class="lists-bot">
                                <p>${project.teamName}</p>
                                <ul class="count">
                                    <li><i class="fa-solid fa-eye"></i>${project.views}회</li>
                                    <li><i class="fa-regular fa-thumbs-up"></i>${project.likes}개</li>
                                </ul>
                            </div>
                        </div>
                    </a>
                `);
            });
        }
    }).fail(error => {
        console.log("실패", error);
    });
}

// 프로젝트 리스트 필터링
function searchProjects(keyword = '') {
    $.ajax({
        url: "/api/show/search",
        type: "GET",
        data: { "keyword": keyword },
        dataType: "json",
        success: function (response) {
            $('.show-search-result').empty();  // 기존 리스트 초기화

            if (response.data && response.data.length === 0) {
                $('.show-search-result').append('<p class="search-null">프로젝트가 존재하지 않습니다. 다시 검색해주세요.</p>');
            } else if (response.data) {
                response.data.forEach(project => {
                    let skillIconsHtml = '';
                    let count = 0;

                    project.skills.forEach(skill => {
                        if (count < 6) {
                            let iconUrl = getSkillIcon(skill);
                            skillIconsHtml += iconUrl ? `<img src="${iconUrl}" alt="${skill}" style="width:25px; height:25px;"/>` : `<li>${skill}</li>`;
                            count++;
                        }
                    });

                    let projectTypeClass = project.projectType === '사이드 프로젝트' ? 'pj' : 'study';

                    $('.show-search-result').append(`
                        <a href="/project/show/${project.projectId}" class="show-box">
                            <div class="img-wrap">
                                <img src="/upload/${project.imageUrl}" alt="프로필 이미지"/>
                            </div>
                            <div class="box-text">
                                <span class="pj-type ${projectTypeClass}">${project.projectType}</span>
                                <h2>${project.projectName}</h2>
                                <ul class="skill">
                                    ${skillIconsHtml}
                                </ul>
                                <div class="lists-bot">
                                    <ul class="count">
                                        <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
                                        <li><i class="fa-regular fa-thumbs-up"></i> ${project.likes}개</li>
                                    </ul>
                                </div>
                            </div>
                        </a>
                    `);
                });
            } else {
                console.error("응답 데이터가 정의되지 않았습니다.");
            }
        },
        error: function (error) {
            console.log("Error: ", error);
        }
    });
}

function clearSearch() {
    document.querySelector(".show-ipt").value = '';
    searchProjects();
}

function handleKeyDown(event) {
    if (event.key === 'Enter') {
        searchProjects(event.target.value);
    }
}

// 이벤트 리스너 추가
document.querySelector(".show-ipt").addEventListener('keydown', handleKeyDown);
document.querySelector(".search-remove").addEventListener('click', clearSearch);

// 사용자 프로젝트 리스트 가져오기
function myProjectList(memberId) {
    if (memberId == 0)
        alert("로그인부터 하셔야합니다 !");
    else
        window.location.assign(`/member/projectList/${memberId}`);
}

// 기술 스택 아이콘 가져오기
function getSkillIcon(skill) {
    const skillIcons = {
        'AWS': '/img/aws.svg',
        'Docker': '/img/docker.svg',
        'Figma': '/img/figma.svg',
        'Flutter': '/img/flutter.svg',
        'Git': '/img/git.svg',
        'Java': '/img/java.svg',
        'JavaScript': '/img/javascript.svg',
        'Jest': '/img/jest.svg',
        'Kotlin': '/img/kotlin.svg',
        'MongoDb': '/img/mongodb.svg',
        'MySQL': '/img/mysql.svg',
        'Nodejs': '/img/nodejs.svg',
        'php': '/img/php.svg',
        'Python': '/img/python.svg',
        'React': '/img/react.svg',
        'ReactNative': '/img/reactnative.svg',
        'Spring': '/img/spring.svg',
        'Svelte': '/img/svelte.svg',
        'TypeScript': '/img/typescript.svg',
        'Vue': '/img/vue.svg'
    };

    return skillIcons[skill] || null;
}
